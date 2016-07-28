<%@ page language="java" pageEncoding="UTF-8"%><%
// remove LF
%><div class="panel panel-default">
  <div class="panel-heading">
    Angular: Hello {{ yourname }} !
  </div>
  <div class="panel-body">
    <label for="">Name: </label>
    <input type="text" class="form-control" ng-model="yourname" placeholder="Enter a name here..." name="name" value="" />
  </div>
</div>
