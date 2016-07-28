<%@ page language="java" pageEncoding="UTF-8"%>
<div class="panel panel-default" ng-controller="PhoneListCtrl">
  <div class="panel-heading">
    <div class="panel-title">
      Search: <input type="text" class="noshadow" ng-model="query" value="" />
    </div>
  </div>
  <div class="panel-body">
    <div class="block">
      Order by: <select ng-model="orderProp">
        <option value="name">Alphabetical</option>
        <option value="age">Newest</option>
        <option value="-age">Oldest</option>
      </select>
    </div>
    <hr />
    <ul>
      <li ng-repeat="phone in phones | filter:query | orderBy:orderProp" class="thumbnail">
        <span>{{phone.name}}</span><p>{{phone.snippet}}</p></li>
    </ul>
    <p>Total number of phones: {{phones.length}}</p>
  </div>
</div>
