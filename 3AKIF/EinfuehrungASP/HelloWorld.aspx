<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="HelloWorld.aspx.cs" Inherits="EinfuehrungASP.HelloWorld" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Hello World</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
  
        <table>
            <tr>
                <td>Name</td>
                <td><asp:TextBox ID="tbName" runat="server"></asp:TextBox> </td>
            </tr>
            <tr>
                <td>Geburtsdatum</td>
                <td><asp:TextBox ID="tbGeburt" runat="server"></asp:TextBox> </td>
            </tr>
            <tr>
                <td>Klasse</td>
                <td>
                    <asp:DropDownList ID="lKlasse" runat="server" SelectMethod ="klassen">
                      </asp:DropDownList>
                </td>
            </tr>


        </table>

                    
        
        <br />
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
            ControlToValidate="tbName" EnableClientScript="False" 
            ErrorMessage="Bitte Name eingeben"></asp:RequiredFieldValidator>
        <br />
        <br />

        <br />

                    <asp:Button ID="ok" runat="server" Text="OK" OnClick="ok_Click" />

        
        <br />
        <br />
        <asp:Label ID="lbAusgabe" runat="server" ></asp:Label>

        
    </div>
    </form>
</body>
</html>
