<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file = "../includes/header.jsp" %>
 <!-- header -->
 
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">BOARD REGISTER</h1>
         </div>
         <!-- /.col-lg-12 -->
     </div>
     <!-- /.row --> 
      <div class="row">
         <div class="col-lg-12">
             <div class="panel panel-default">
                 <div class="panel-heading"></div>
                 <!-- /.panel-heading -->
                 <div class="panel-body">
	                  	<div class="form-group">
	                  		<label>bno</label> <input class = "form-control" name="bno" value="<c:out value='${board.bno }'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>title</label> <input class = "form-control" name="title" value="<c:out value='${board.title }'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>contents</label> <input class = "form-control" name="contents" value="<c:out value='${board.contents}'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>writer</label> <input class = "form-control" name="writer" value="<c:out value='${board.writer}'/>"readonly="readonly">
	                  	</div>
	                  	<button data-oper='modify' class="btn btn-default">modify button</button>
	                  	<button data-oper='list'  class="btn btn-default">list</button>
	                  	 
	                  	 <form id="operForm" action="/board/modify" method="get">
	                  	 	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
	                  	 	<input type="hidden" id="pagenum" name="pagenum" value='<c:out value="${cri.pagenum}"/>'>
	                  	 	<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}"/>'>
	                  	 	<input type="hidden" id="amount" name="keyword" value='<c:out value="${cri.keyword}"/>'>
	                  	 	<input type="hidden" id="amount" name="type" value='<c:out value="${cri.type}"/>'>
	                  	 </form>  	
	                  
                 </div>
                 <!-- /.panel-body -->
             </div>
             <!-- /.panel -->
         </div>
         <!-- /.col-lg-12 -->
     </div>
     <!-- /.row -->    
     
     
     <script type="text/javascript" src="/resources/js/reply.js"></script>
     <script type="text/javascript">
	$(document).ready(function(){
		var operForm =$("#operForm");
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action","/board/modify").submit();
		});
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list").submit();
		});
	});
	
	console.log("===============");
	console.log("JS test");
	
	 var bnoValue = '<c:out value="${board.bno}"/>';
	/*  //for replyservice add test
	replyService.add(
		{ reply:"난 오늘밤도 너를 떠올려 지금 이순간에도 어김없이 너를 떠올려 니가 모르게~~~~~~" ,replyer:"노래가 좋구만..",bno:bnoValue},
		function (result){
			alert("Result : "+result);
		}
	);  */

	replyService.getList({bno:bnoValue,page:1},function(list){
		
		for(var i =0 ,len = list.length || 0 ; i<len ;i++ ){
			console.log(list[i]);
		} 
	});
/* 	console.log("===============");
	console.log("오늘 한게 다 안되면 어케..?"); */
	
	replyService.remove(28,function(count){
		console.log(count);
		if(count === "success"){
			alert("성공좀... 나와라");
		}
	},function(err){alert('error..')});
	
	 replyService.update({
		 rno: 27,
		 bno:bnoValue,
		 reply:"내게 진심을 바란다면 술을 절대 주지마~~"
	 },function(result){
		 alert("남자는 전부 또옥~같아");
	 });
	

	 
	 
	</script>
 	 
     
<!-- footer -->
<%@include file="../includes/footer.jsp"%>