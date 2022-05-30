<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2022/5/27
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物</title>
    <script type="text/javascript" src="js/jQuery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function (){
            alert("登入成功！");
            $("#btn01").click(function (){
              //  $("#gw").html("购物成功！")
                $.ajax({
                    url: "ajaxtest" ,
                    type : "get" ,
                    async : "true" ,
                  //  contentType: "application/json",
                    dataType:"json",
                    success : function(data){
                       // $("#gw").html(data)
                        $("#id").html(data.id)
                        $("#quantity").html(data.quantity)
                        $("#commodity").html(data.commodity)
                        $("#ItemID").html(data.itemID)
                        $("#Totalamount").html(data.totalAmount)
                        $("#time").html(data.time);


                            alert(data)

                        alert("hi!");
                    }

                })
            })
        })
    </script>
</head>
<body>
<div id="gw" style="width: 400px; height:120px; background-color:pink;">
    <p>购物车</p>
    <form action="sale" method="post">
        <table>
            <tr>
                <td>ItemID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="quantity"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="点击购买" ></td>
            </tr>
        </table>
    </form>
</div>
<hr>
<button id="btn01" >查看订单</button>
<br>
<br>
<div id="xinxi" style="width: 400px; height:250px; background-color:papayawhip;">
    交易序号: <span id="id"></span><br/><br/>
    商品编号: <span id="ItemID"></span><br/><br/>
    商品名称: <span id="commodity"></span><br/><br/>
    购买数量: <span id="quantity"></span><br/><br/>
    支付金额: <span id="Totalamount"></span><br/><br/>
    交易时间: <span id="time"></span><br/><br/>
</div>

</body>
</html>
