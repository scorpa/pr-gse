<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Bibliothek.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">

    <div>
        <asp:GridView ID="GBuecher" runat="server" />
    </div>

    <div>
        <table>
            <tr>
                <td>Titel</td>
                <td><asp:TextBox ID="TBTitel" runat="server" /></td>
            </tr>
            <tr>
                <td>ISBN</td>
                <td><asp:TextBox ID="TBIsbn" runat="server" /></td>
            </tr>
            <tr>
                <td>Seiten</td>
                <td><asp:TextBox ID="TBSeiten" runat="server" /></td>
            </tr>

        </table>

        <asp:Button ID="BnNeu" runat="server" Text="Neu" OnClick="BnNeu_Click" />
 

    </div>
    </form>
</body>
</html>
