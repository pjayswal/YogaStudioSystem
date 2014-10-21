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
	<h3 class="text-center login-title"><a href="../">Welcome to Yoga Studio's Online Shop</a></h3><br/>
<div class="container theme-showcase" role="main"> 
	 <!-- begin:product-category --> 
        <div class="col-sm-2">
          <div class="list-group">
          <div class="panel panel-info">
          <div class="panel-heading">
              <h3 class="panel-title">Categories</h3>
            </div>
          <c:forEach var="category" items="${categories}">
            <a href="../${category.id}" class="list-group-item">${category.name}</a>
		  </c:forEach>
          </div>
        </div>
        </div>
     <!-- end:product-category --> 
     <!-- begin:shopping-cart-details --> 
        <div class="col-sm-7"><h3>Your Cart</h3>
              <hr />
                
              <table class="table table-bordered table-striped">
               <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
                  <th>Qty</th>
                  <th>Price</th>
                  <th>Total</th>
                </tr>
               </thead>
               <tbody>
          <c:set var = "ol" value="${orderLines}"/>
          <c:if test="${ol==null || ol=='[]'}" >
          		<tr>
                  <td colspan="6">Your Shopping Cart is empty.</td>
                </tr>
          </c:if>
          <c:set var = "total" value="${0}"/>        
          <c:forEach var="orderLine" items="${orderLines}">
                <tr>
                  <td><img  src="../../admin/productpic/${orderLine.product.id}" class="img-cart" /></td>
                  <td><strong>${orderLine.product.name}</strong></td>
                  <td>
                    <form class="form-inline" role="form" action="../cart/" method="post">
                      <input class="form-control" type="text" name="quantity" value="${orderLine.quantity}" size="1" />
                      <input class="form-control" type="hidden" name="id" value="${orderLine.id}" />
                      <button  title="Update" class="btn btn-default"><i class="fa fa-pencil"></i></button>
                      <a href="remove/${orderLine.product.id}" class="btn btn-primary" rel="tooltip" title="Delete"><i class="fa fa-trash-o"></i></a>
                    </form>
                  </td>
                  <td>$<fmt:formatNumber type="number" maxFractionDigits="2" value="${orderLine.amount/orderLine.quantity}"/></td>
                  <td>$<fmt:formatNumber type="number" maxFractionDigits="2" value="${orderLine.amount}"/></td>
                </tr>
          <c:set var="total" value="${total + orderLine.amount}"/>  
		  </c:forEach>
                <tr>
                  <td colspan="6">&nbsp;</td>
                </tr>
                <tr>
                  <td colspan="4" class="text-right">Total Product</td>
                  <td>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${total}"/></td>
                </tr>
                <tr>
                  <td colspan="4" class="text-right">Total Shipping</td>
                  <td>FREE</td>
                </tr>
                <tr>
                  <td colspan="4" class="text-right"><strong>Total</strong></td>
                  <td>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${total}"/></td>
                </tr>
               </tbody>
              </table>
              <a href="../" class="btn btn-default">Continue Shopping</a>
              <a href="../checkout/" class="btn btn-primary pull-right">Checkout</a>
        </div>        
     <!-- begin:shopping-cart-details --> 
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
                      <div class="col-sm-7 col-xs-7">${orderLine.quantity} <a href="../product/${orderLine.product.id}">${orderLine.product.name}</a></div>
                      <div class="col-sm-5 col-xs-5 text-right"><strong>$<fmt:formatNumber type="number" maxFractionDigits="2"  value="${orderLine.amount}"/></strong> <a href="remove/${orderLine.product.id}"><i class="fa fa-trash-o"></i></a></div>
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
                        <a class="btn btn-default" href="">Cart</a>
                      </div>
                      <div class="col-sm-6 col-xs-6 text-right">
                        <a class="btn btn-primary" href="../checkout/">Checkout</a>
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