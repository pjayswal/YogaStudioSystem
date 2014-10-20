<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
<jsp:param value="a" name="a"/>
</jsp:include>
<title>Welcome to Administration</title>
</head>
<body>	.<br/>
	.<br/>.
	<h3 class="text-center login-title"><a href="${category.id}">Welcome to Yoga Studio's Online Shop</a></h3><br/>
<div class="container theme-showcase" role="main"> 
	 <!-- begin:product-category --> 
        <div class="col-sm-2">
          <div class="list-group">
          <div class="panel panel-info">
          <div class="panel-heading">
              <h3 class="panel-title">Categories</h3>
            </div>
          <c:forEach var="category" items="${categories}">
            <a href="${category.id}" class="list-group-item">${category.name}</a>
		  </c:forEach>
          </div>
        </div>
        </div>
     <!-- end:product-category --> 
     <!-- begin:product-listing 
        <div class="col-sm-7">
        <div class="list-group">
          <c:forEach var="product" items="${products}">
            <a href="product/${product.id}" class="list-group-item">
              <h4 class="list-group-item-heading">${product.name}</h4><span class="badge">$ ${product.price}</span>
              <p class="list-group-item-text">${product.description}</p>
            </a>
          </c:forEach>
          </div> 
      <!-- end:product-listing --> 
       
       
      <!-- begin:product-listing --> 
<div class="col-sm-7">
<c:set var = "count" value="${1}"/>
<c:forEach var="product" items="${products}">
   <c:if test="${count%3==1}" ><div class="row product-container"></c:if>
        <div class="col-md-4 col-sm-3 col-xs-6">
          <div class="thumbnail product-item">
            <a href="product/${product.id}"><img alt="" src="/YogaStudioWebPortal/resources/img/product4.jpg">
            <div class="caption"><a href="product/${product.id}">
              ${product.name}</a>
              <p class="product-item-price">$${product.price}</p>
            </div>
            <div class="product-item-badge">New</div>
          </div>
        </div> 
   <c:if test="${count%3==0}" ></div></c:if>
   <c:set var="count" value="${count + 1}"/> 	
</c:forEach>
<c:if test="${(count-1)%3!=0}" ></div></c:if>
</div>
      <!-- end:product-listing -->
       
       
       
       
      <!-- begin:shopping-cart -->
        <div class="col-sm-3">
        <div class="panel panel-success">
          <div class="panel-heading">
              <h3 class="panel-title">Shopping Cart</h3>
          </div>  
		</div>        
          <ul class="list-unstyled">
          <c:set var = "ol" value="${orderLines}"/>
          <c:if test="${ol==null || ol=='[]'}" >
            <li>
              	Your Shopping Cart is empty.
            </li>
          </c:if>
          <c:set var = "total" value="${0}"/>        
          <c:forEach var="orderLine" items="${orderLines}">
                  <li>
                    <div class="row">
                      <div class="col-sm-7 col-xs-7">${orderLine.quantity} <a href="product/${orderLine.product.id}">${orderLine.product.name}</a></div>
                      <div class="col-sm-5 col-xs-5 text-right"><strong>$<fmt:formatNumber type="number" maxFractionDigits="2"  value="${orderLine.amount}"/></strong> <a href="cart/remove/${orderLine.product.id}"><i class="fa fa-trash-o"></i></a></div>
                    </div>
                  </li>
          <c:set var="total" value="${total + orderLine.amount}"/>  
		  </c:forEach></ul>
		  <c:if test="${ol!=null and ol!='[]'}" >              	
                <ul class="list-unstyled total-price">
                  <li>
                    <div class="row">
                      <div class="col-sm-8 col-xs-8"><strong>Total</strong></div>
                      <div class="col-sm-4 col-xs-4 text-right"><strong>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${total}"/></strong></div>
                    </div>
                  </li></ul>
                  <ul class="list-unstyled total-price">
                  <li>
                    <div class="row">
                      <div class="col-sm-6 col-xs-6">
                        <a class="btn btn-default" href="cart/">Cart</a>
                      </div>
                      <div class="col-sm-6 col-xs-6 text-right">
                        <a class="btn btn-primary" href="">Checkout</a>
                      </div>
                    </div>
                  </li>
                </ul>
            
          </c:if>
		</div>		
      <!-- end:shopping-cart -->
</div>
</body>
</html>