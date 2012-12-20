<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PersonenAnzeige.aspx.cs" Inherits="Tabellen.PersonenAnzeige" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AutoGenerateColumns="False" DataKeyNames="Id" DataSourceID="ObjectDataSource1" PageSize="3" ShowFooter="True">
            <Columns>
                <asp:TemplateField ShowHeader="False">
                    <EditItemTemplate>
                        <asp:LinkButton ID="LinkButton1" runat="server" CausesValidation="True" CommandName="Update" Text="Update"></asp:LinkButton>
                        &nbsp;<asp:LinkButton ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Cancel" Text="abbrechen"></asp:LinkButton>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:LinkButton ID="LinkButton1" runat="server" CausesValidation="False" CommandName="Edit" Text="bearbeiten"></asp:LinkButton>
                        &nbsp;<asp:LinkButton ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Delete" Text="löschen"></asp:LinkButton>
                    </ItemTemplate>
                    <FooterTemplate>
                        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Neu" />
                    </FooterTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Id" SortExpression="Id">
                    <EditItemTemplate>
                        <asp:Label ID="Label1" runat="server" Text='<%# Eval("Id") %>'></asp:Label>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label2" runat="server" Text='<%# Bind("Id") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Name" SortExpression="Name">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Name") %>'></asp:TextBox>
                    </EditItemTemplate>
                    <FooterTemplate>
                        <asp:TextBox ID="TbName" runat="server"></asp:TextBox>
                       
                    </FooterTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label3" runat="server" Text='<%# Bind("Name") %>'></asp:Label>
                    </ItemTemplate>
                    <ItemStyle ForeColor="Red" />
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Geburtstag" SortExpression="Geburtstag">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox2" runat="server" Text='<%# Bind("Geburtstag") %>'></asp:TextBox>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label4" runat="server" Text='<%# Bind("Geburtstag", "{0:d}") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Kinder" SortExpression="Kinder">
                    <EditItemTemplate>
                        <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="ObjectDataSource2" SelectedValue='<%# Bind("Kinder") %>'>
                        </asp:DropDownList>
                        <asp:ObjectDataSource ID="ObjectDataSource2" runat="server" SelectMethod="AuswahlListe" TypeName="Tabellen.PersonenVerwaltung"></asp:ObjectDataSource>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label1" runat="server" Text='<%# Bind("Kinder") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DeleteMethod="Delete" SelectMethod="Select" TypeName="Tabellen.PersonenVerwaltung" UpdateMethod="Update">
            <DeleteParameters>
                <asp:Parameter Name="Id" Type="Int32" />
            </DeleteParameters>
            <UpdateParameters>
                <asp:Parameter Name="Id" Type="Int32" />
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="Geburtstag" Type="DateTime" />
                <asp:Parameter Name="Kinder" Type="String" />
            </UpdateParameters>
        </asp:ObjectDataSource>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <br />
        <br />
        <br />
    
    </div>
    </form>
</body>
</html>
