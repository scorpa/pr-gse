<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Warenkorb.aspx.cs" Inherits="Bibliothek.Warenkorb" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="BuchListe" runat="server" />
    
    </div>

    <div>
        <asp:DropDownList ID="Auswahl" AutoPostBack="true" runat="server" />

        <asp:Button ID="BtnEinfuegen" Text="Einfügen" runat="server" OnClick="BtnEinfuegen_Click" />

    </div>

    </form>
</body>
</html>
