<%@ Page Language="C#" AutoEventWireup="true" 
    CodeBehind="Default.aspx.cs" Inherits="ASPEinfuehrung.Default"  %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="tbName" runat="server"></asp:TextBox>
        <br />
        Geburtsdatum&nbsp;
        <asp:TextBox ID="tbDatum" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:DropDownList ID="klassenliste" runat="server">
            <asp:ListItem Text="3AKIF" />
            <asp:ListItem Text="3BKIF" />
        </asp:DropDownList>
        <br />
        <br />
        <br />
        <asp:Button ID="Button1" runat="server" Text="OK" OnClick="Button1_Click" />
    
        <br />
        <br />
        <br />
        <asp:Label ID="lbAusgabe" runat="server" ></asp:Label>
    
    </div>
    </form>
</body>
</html>
