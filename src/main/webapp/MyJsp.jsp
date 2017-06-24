<%--
  Created by IntelliJ IDEA.
  User: sunbin
  Date: 2017/6/16
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script>

    function upa(index){
       var indexss=index-1;

       if(indexss<1){

           alert("已经是第一页了");
       }else {
           alert(indexss);
           window.location.href="Servlet?pageindex="+indexss+"&name="+$("#id").val()+"&type="+$('#thire option:selected') .val();//.val();
       }
    }
    function add(index,count){
        var indexs=index+1;

        if(indexs>count){
            alert("已经是最后一页了");

        }else{

            window.location.href="Servlet?pageindex="+indexs+"&name="+$("#id").val()+"&type="+$('#thire option:selected') .val();
        }


    }

</script>
             <form action="Servlet" method="post">
                 <input id="two" name="name" type="text" value="${name==null?"":name}"/>
                 <select id="thire" name="type" >
                     <option value="${type}"> ${type==0?"请选择":type}</option>
                     <option value="8"> 8</option>
                     <option value="2"> 2</option>
                     <option value="3"> 3</option>
                     <option value="4"> 4</option>
                 </select>
               <button type="submit" >查询</button>

             </form>
<p>${num2}1111  </p>

        <table>


            <tr>
                <td>ID</td>
                <td>商品名称</td>
                <td>商品类型</td>
                <td>商品价格</td>
            </tr>

      <c:forEach items="${list}" var="item">
               <tr>
                   <td> ${item.id}</td>
                   <td> ${item.goodsname}</td>
                   <td> ${item.goodsNo}</td>
                   <td> ${item.goodsprice}</td>
               </tr>
      </c:forEach>

        </table>
                 <p>[ ${pageIndex==null?"1":pageIndex} /  ${count} ]</p>      <a href="#" onclick="upa(${pageIndex})">上一页</a><a href="#" onclick="add(${pageIndex},${count})">下一页</a>
</body>
</html>
