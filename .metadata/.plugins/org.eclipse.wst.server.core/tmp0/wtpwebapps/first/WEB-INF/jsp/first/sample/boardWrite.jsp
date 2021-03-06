<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<!-- 글 작성 페이지 -->
<!-- 어떤 화면을 만들더라도 body 안의 내용만 바뀌고 나머지는 항상 똑같이 작성됨 -->
<body>
    <form id="frm">
        <table class="board_view">
            <colgroup>
                <col width="15%">
                <col width="*"/>
            </colgroup>
            <caption>게시글 작성</caption>
            <tbody>
                <tr>
                    <th scope="row">제목</th>
                    <td><input type="text" id="TITLE" name="TITLE" class="wdp_90"></input></td>
                </tr>
                <tr>
                    <td colspan="2" class="view_text">
                        <textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
                    </td>
                </tr>
            </tbody>
        </table>
         
        <a href="#this" class="btn" id="write" >작성하기</a>
        <a href="#this" class="btn" id="list" >목록으로</a>
    </form>
     
    <%@ include file="/WEB-INF/include/include-body.jspf" %>
    <script type="text/javascript">
	    $(document).ready(function(){
	        $("#list").on("click", function(e){ //목록으로 버튼
	            e.preventDefault();
	            fn_openBoardList();
	        });    
	        
	        $("#write").on("click", function(e){ //작성하기 버튼
	            e.preventDefault();
	            fn_insertBoard();
	        });
	    });
	     
	    //대부분 form 태그를 사용해서 input submit을 한다. 
	    //하지만 이렇게 하면 폼을 만들필요가 없는 부분에서도 폼을 만드는 불편함 등이 있다
	    function fn_openBoardList(){
	    	//common.js에 만든 ComSubmit 함수(submit 기능)
	        var comSubmit = new ComSubmit(); //js 객체 생성
	        //jstl 태그로 ContextPath를 자동으로 붙이도록 함
	        //만약 jstl을 사용하지 않는다면 comSubmit.setUrl("/first/sample/openBoardList.do") 라고 작성
	        comSubmit.setUrl("<c:url value='/sample/openBoardList.do' />");
	        comSubmit.submit();
	    }
	    
	    //글 작성 버튼
	    function fn_insertBoard(){
	    	//form의 아이디 값인 frm 인자값으로 넘겨줌
	        var comSubmit = new ComSubmit("frm");
	        comSubmit.setUrl("<c:url value='/sample/insertBoard.do' />");
	        comSubmit.submit();
	    }
    </script>
</body>
</html>
