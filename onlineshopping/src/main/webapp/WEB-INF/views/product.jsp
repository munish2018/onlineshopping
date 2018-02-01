<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

        <h3>Welcome, Enter The Product Details</h3>
        <form method="POST" action="">
             <table>
                <tr>
                    <td>Id</td>
                    <td><input type=text/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type=text/></td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td><input type=text/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type=text/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                    <td><input type="reset" value="Cancel"/></td>
                </tr>
            </table>
        </form>
