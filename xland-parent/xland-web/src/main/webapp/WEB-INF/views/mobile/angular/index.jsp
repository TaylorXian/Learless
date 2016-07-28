<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/templates/bootstrap/basepath.jsp" %>
<!DOCTYPE html>
<html lang="zh" ng-app="MobileXland">
  <head>
    <meta charset="utf-8" />
    <base href="<%= base %>" />
    <title>Mobile Angular UI</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimal-ui" />
    <meta name="apple-mobile-web-app-status-bar-style" content="yes" />
    <link rel="shortcut icon" href="static/demo/favicon.png" type="image/x-icon" />
    <link rel="stylesheet" href="static/dist/css/mobile-angular-ui-hover.min.css" />
    <link rel="stylesheet" href="static/dist/css/mobile-angular-ui-base.min.css" />
    <link rel="stylesheet" href="static/dist/css/mobile-angular-ui-desktop.min.css" />
    <link rel="stylesheet" href="resources/css/xland.base.css" />
    <script src="//cdn.bootcss.com/angular.js/1.3.0/angular.js"></script>
    <script src="//cdn.bootcss.com/angular.js/1.3.0/angular-route.js"></script>
    <script src="static/dist/js/mobile-angular-ui.js"></script>
    <!-- Required to use $touch, $swipe, $drag and $translate services -->
    <script src="static/dist/js/mobile-angular-ui.gestures.js"></script>
    <script src="resources/js/mobile/xland.base.js"></script>
  </head>
  <body>
    <div class="app-body">
      <div class="app-content">
        <div class="panel panel-default">
          <div class="panel-heading">
            Angular: Hello {{ yourname }} !
          </div>
          <div class="panel-body">
            <label for="">Name: </label>
            <input type="text" class="form-control" ng-model="yourname" placeholder="Enter a name here..." name="name" value="" />
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
