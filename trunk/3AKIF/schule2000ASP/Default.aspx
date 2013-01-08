<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="schule2000ASP.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:DropDownList ID="KlassenAuswahl" runat="server" DataTextField="K_Bez" DataValueField="K_ID" AutoPostBack="True" OnSelectedIndexChanged="KlassenAuswahl_SelectedIndexChanged">
        </asp:DropDownList>
        <br />
        <br />
        <br />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="SchuelerObjekte">
            <Columns>
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                <asp:BoundField DataField="S_SCHNR" HeaderText="S_SCHNR" SortExpression="S_SCHNR" />
                <asp:BoundField DataField="S_Name" HeaderText="S_Name" SortExpression="S_Name" />
                <asp:BoundField DataField="S_Vorname" HeaderText="S_Vorname" SortExpression="S_Vorname" />
                <asp:TemplateField HeaderText="S_Gebdat" SortExpression="S_Gebdat">
                    <EditItemTemplate>
                        <asp:Calendar ID="Calendar1" runat="server" SelectedDate='<%# Bind("S_Gebdat") %>'></asp:Calendar>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label1" runat="server" Text='<%# Bind("S_Gebdat", "{0:d}") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:BoundField DataField="S_Adresse" HeaderText="S_Adresse" SortExpression="S_Adresse" />
            </Columns>
        </asp:GridView>
        <asp:ObjectDataSource ID="SchuelerObjekte" runat="server" DeleteMethod="Delete" SelectMethod="Select" TypeName="schule2000ASP.SchuelerVerwaltung" UpdateMethod="Update">
            <DeleteParameters>
                <asp:Parameter Name="s_schnr" Type="Int32" />
            </DeleteParameters>
            <SelectParameters>
                <asp:SessionParameter Name="k_id" SessionField="klasse" Type="String" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="s_schnr" Type="Int32" />
                <asp:Parameter Name="s_name" Type="String" />
                <asp:Parameter Name="s_vorname" Type="String" />
                <asp:Parameter Name="s_gebdat" Type="DateTime" />
                <asp:Parameter Name="s_adresse" Type="String" />
            </UpdateParameters>
        </asp:ObjectDataSource>
    
        <br />
        <br />
        <br />
        <asp:GridView ID="GridView2" runat="server" AutoGenerateColumns="False" DataKeyNames="S_SCHNR" DataSourceID="SchuelerEntity">
            <Columns>
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                <asp:BoundField DataField="S_SCHNR" HeaderText="S_SCHNR" ReadOnly="True" SortExpression="S_SCHNR" />
                <asp:BoundField DataField="S_Name" HeaderText="S_Name" SortExpression="S_Name" />
                <asp:BoundField DataField="S_Vorname" HeaderText="S_Vorname" SortExpression="S_Vorname" />
                <asp:BoundField DataField="S_Gebdat" HeaderText="S_Gebdat" SortExpression="S_Gebdat" />
                <asp:BoundField DataField="S_Adresse" HeaderText="S_Adresse" SortExpression="S_Adresse" />
                <asp:BoundField DataField="klasse.K_ID" HeaderText="klasse.K_ID" SortExpression="klasse.K_ID" />
            </Columns>
        </asp:GridView>
        <asp:EntityDataSource ID="SchuelerEntity" runat="server" ConnectionString="name=Schule2000" DefaultContainerName="Schule2000" EnableDelete="True" EnableUpdate="True" EntitySetName="schueler">
        </asp:EntityDataSource>
    
    </div>
    </form>
</body>
</html>
