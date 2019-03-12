<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div id="addChapterDiv" align="center">
    <form id="addChapterForm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/banner/addBanner">
        <table>

                <td>上传：</td>
                <td><input name="addFile"  type="file" style="width:300px"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"/></td>
            </tr>
        </table>
    </form>
</div>