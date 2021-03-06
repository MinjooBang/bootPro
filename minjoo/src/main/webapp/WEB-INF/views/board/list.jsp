<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file = "../includes/header.jsp" %>
 
 <div class="row">
     <div class="col-lg-12">
         <h1 class="page-header">Tables</h1>
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 <div class="row">
     <div class="col-lg-12">
         <div class="panel panel-default">
             <div class="panel-heading">BOARD LIST PAGE</div>
             <!-- /.panel-heading -->
             <div class="panel-body">
                 <div class="table-responsive">
                     <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                         <thead>
                             <tr>
                                 <th>번호</th>
                                 <th>제목</th>
                                 <th>작성자</th>
                                 <th>작성일</th>
                                 <th>수정일</th>
                             </tr>
                         </thead>
                         <c:forEach items="${list}" var="board">
                         
                          <tr class="odd gradeX">
                                 <td><c:out value="${board.bno}"></c:out></td>
                                 <td><a class="move" href='<c:out value="${board.bno}"/>'><c:out value="${board.title}"></c:out></a></td>
                                 <td><c:out value="${board.contents}"></c:out></td>
                               	<td class="center"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td> 
                               	<td class="center"><fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd"/></td> 
                                 <!-- <td class="center">X</td> -->
                          </tr>
                         </c:forEach>
                     </table>
                     <!--  paging -->
                		<div class="row">
                			<div class="col-lg-12">
                				<form id ="searchForm" action="/board/list" method="get">
                					<select name="type">
                						<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected':''}"/>>---</option>
                						<option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected':''}"/>>제목</option>
                						<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected':''}"/>> 내용</option>
                						<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected':''}"/>>작성자</option>
                						<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected':''}"/>>제목or내용</option>
                						<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected':''}"/>>제목or작성자</option>
                						<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW' ? 'selected':''}"/>>제목or내용or작성사</option>
                					</select>
                					<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'>
                					<input type='hidden' name='pagenum' value='<c:out value="${pageMaker.cri.pagenum}"/>'>
                					<input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>'>
                					<button class="btn btn-default">search</button>
                				</form>
                			</div>
                			<div class="col-sm-6">
                				<div class="dataTables_paginate paging_simple_numbers"> 
                					<ul class="pagination">
                						<c:if test="${pageMaker.prev}">
                							<li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="${pageMaker.startPage - 1 }">Previous</a></li>
                						</c:if>
                						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage }">
                							<li class="paginate_button ${pageMaker.cri.pagenum == num ? 'active':'' }" aria-controls="dataTables-example" tabindex="0"><a href="${num}">${num}</a></li>
                						</c:forEach>
                						<c:if test="${pageMaker.next}">
                							<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="${upageMaker.endPage +1 }">next</a></li>
                						</c:if>
                					</ul>
                				</div>
                			</div>
                		</div>
                		<form id="actionForm" action="/board/list" method="get">
                			<input type="hidden" name="pagenum" value="${pageMaker.cri.pagenum }">
                			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                			<input type="hidden" name="type" value="<c:out value ='${pageMaker.cri.type }'/>"/>
                			<input type="hidden" name="keyword" value="<c:out value ='${pageMaker.cri.keyword }'/>"/>
                		</form>
               		<!-- end pagination -->
                 </div>
                
             </div>
             <!-- /.panel-body -->
         </div>
         <!-- /.panel -->
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 
            <script type="text/javascript">
            $(document).ready(function(){
            	
            	var actionForm = $("#actionForm");
            	
            	$(".paginate_button a").on("click",function(e){
            		
            		e.preventDefault();
            		console.log('click');
            		actionForm.find("input[name='pagenum']").val($(this).attr("href"));
            		actionForm.submit();
            	});
            	
            	$(".move").on("click",function(e){
            		e.preventDefault();
            		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
            		actionForm.attr("action","/board/get");
            		actionForm.submit();
            	});
            	
            	var searchForm = $("#searchForm")
            	
            	$("#searchForm button").on('click',function(e){
            	
            		if (!searchForm.find("option:selected").val()){
            			alert("검색종류를 선택하세요.");
            			return false;
            		}
            		if(!searchForm.find("input[name='keyword']").val()){
            			alert("키워드를 입력하세요.");
            			return false;
            		}
            		
            		searchForm.find("input[name='pagenum']").val(1);
            		e.preventDefault();
            		searchForm.submit();
            	});
            	
            	
            });
            	
            	
            </script>
            
     

   <%@include file="../includes/footer.jsp"%>