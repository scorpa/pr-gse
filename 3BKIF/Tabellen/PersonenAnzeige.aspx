<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PersonenAnzeige.aspx.cs" Inherits="Tabellen.PersonenAnzeige" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AutoGenerateColumns="False" DataKeyNames="Id" DataSourceID="ObjectDataSource1" PageSize="3">
            <Columns>
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                <asp:BoundField DataField="Id" HeaderText="Id" ReadOnly="True" SortExpression="Id" />
                <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
                <asp:BoundField DataField="Geburtstag" DataFormatString="{0:d}" HeaderText="Geburtstag" SortExpression="Geburtstag" />
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
            </UpdateParameters>
        </asp:ObjectDataSource>
        <br />
        <br />
    
    </div>
    </form>
</body>
</html>
