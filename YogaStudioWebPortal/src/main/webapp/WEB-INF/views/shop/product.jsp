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
          <c:set var = "listcatid" value="${category.id}"/> 
          <c:set var = "catid" value="${catid}"/> 
            <a href="../${category.id}" class="list-group-item
            		<c:if test="${listcatid==catid}" >active</c:if>
            												">${category.name}</a>
		  </c:forEach>
          </div>
          </div>
        </div>        
     <!-- end:product-category --> 
     <!-- begin:product-details --> 
        <div class="col-sm-7">
        
 <!--       <h3> ${product.name}</h3>
          <ul class="list-group">
            <li class="list-group-item">
              	<span class="badge text-center">$ ${product.price}</span>
              	<p class="list-group-item-text">${product.description}</p>
              	<a href="../cart/${product.id}"><button type="button" class="btn btn-sm btn-success">Add to Cart</button></a>
            </li>
          </ul>--> 
          
          

        <h3> ${product.name}</h3>
              <div class="row">
                <!-- begin:product-image-slider -->
                <div class="col-md-6 col-sm-6">

                        <div class="product-single">
                          <img  src="../../admin/productpic/${product.id}" class="img-responsive">
                        </div>
                </div>
                <!-- end:product-image-slider -->

                <!-- begin:product-spesification -->
                <div class="col-md-6 col-sm-6">
                  <div class="single-desc">
                    <form>
                      <table width="100%">
                        <tbody>
                          <tr class="hidden-xs">
                             <td colspan="3"> ${product.description}</td>
                          </tr>
                          <tr class="hidden-xs">
                              <td><strong>Price</strong></td>
                              <td>: </td>
                              <td> $${product.price}</td>
                          </tr>
                          <tr>
                              <td><strong>Color</strong></td>
                              <td>:</td>
                              <td>
                                <select class="form-control">
                                  <option>Black</option>
                                  <option>Green</option>
                                  <option>Blue</option>
                                  <option>Yellow</option>
                                </select>
                            </td>   
                          </tr>
                          <tr>
                              <td><strong>Size</strong></td>
                              <td>:</td>
                              <td>
                                <select class="form-control">
                                  <option>XS</option>
                                  <option>S</option>
                                  <option>M</option>
                                  <option>L</option>
                                  <option>XL</option>
                                </select>
                              </td>
                          </tr>
                          <tr>
                              <td colspan="3" align="right">
                                <a href="../cart/${product.id}" class="btn btn-sm btn-success">Add to Cart</a>
                              </td>  
                          </tr>
                        </tbody>
                      </table>
                    </form>
                  </div>
                </div>
                <!-- end:product-spesification -->
              </div>
              <!-- break -->
          
          
          
        </div>
     <!-- begin:product-details --> 
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
                      <div class="col-sm-7 col-xs-7">${orderLine.quantity} <a href="${orderLine.product.id}">${orderLine.product.name}</a></div>
                      <div class="col-sm-5 col-xs-5 text-right"><strong>$<fmt:formatNumber type="number" maxFractionDigits="2"  value="${orderLine.amount}"/></strong> <a href="../cart/remove/${orderLine.product.id}"><i class="fa fa-trash-o"></i></a></div>
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
                        <a class="btn btn-default" href="../cart/">Cart</a>
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