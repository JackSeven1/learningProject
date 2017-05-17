<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<script src="./js/jquery.min.js"></script>
  </head>
  <script >
      function submitInfo() {
          var data={ }
          data.payName=$("#pay_name").val();
          data.payCode=$("#pay_code").val();
          data.invoiceCode=$("#invoice_code").val();
          data.invoiceNumber=$("#invoice_number").val();
          data.securityCode=$("#security_code").val();
          data.productName=$("#product_name").val();
          data.productNumber=$("#product_number").val();
          data.productType=$("#product_type").val();
          data.productPrice=$("#product_price").val();
          $.ajax({
              url : "/invoiceinfo/updataInfo",
              type : "POST",
              data :  "data="+JSON.stringify(data),
              dataType: "json",
              async : false,
              success : function(data) {

              }
          })

      }

    
</script>
  <body>
   <div>付款单位名称:<input type="text" id="pay_name"></div>
   <div>付款方识别号:<input type="text" id="pay_code"></div>
   <div>发票代码:<input type="text" id="invoice_code"></div>
   <div>发票号码:<input type="text" id="invoice_number"></div>
   <div>防伪码:<input type="text" id="security_code"></div>
   <div>产品品名规格:<input type="text" id="product_name"></div>
   <div>产品数量:<input type="text" id="product_number"></div>
   <div>计量单位:<input type="text" id="product_type"></div>
   <div>产品价格:<input type="text" id="product_price"></div>
   <button type="button" onclick="submitInfo()">生成</button>
  </body>
</html>
