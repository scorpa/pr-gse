<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WarenkorbVerwaltung.aspx.cs" Inherits="Bibliothek.WarenkorbVerwaltung" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="GWarenkorb" runat="server" />

        <asp:DropDownList ID="DAuswahl" runat="server" AutoPostBack="true"></asp:DropDownList>
    </div>

    <div>
 

        <asp:Button ID="BnHinzu" runat="server" Text="Neu" OnClick="BnHinzu_Click" />
    </div>

    </form>
</body>
</html>
