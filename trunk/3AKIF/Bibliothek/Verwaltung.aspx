<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Verwaltung.aspx.cs" Inherits="Bibliothek.Verwaltung" %>

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
        <table>
            <tr>
                <td>Autor</td>
                <td><asp:TextBox ID="TBAutor" runat="server" /></td>
            </tr>
            <tr>
                <td>Titel</td>
                <td><asp:TextBox ID="TBTitel" runat="server"/></td>
            </tr>
            <tr>
                <td>Preis</td>
                <td><asp:TextBox ID="TBPreis" runat="server"/></td>
            </tr>
        </table>
        <asp:Button Text="Neu" ID="BtnNeu" runat="server" OnClick="BtnNeu_Click" />
    </div>

    </form>
</body>
</html>
