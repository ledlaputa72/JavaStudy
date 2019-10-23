<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>test1</title>

		<!-- Bootstrap -->
		<link href="css/bootstrap.css" rel="stylesheet">

		<!-- Google Web Fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Oswald:400,700,300" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400" rel="stylesheet" type="text/css">

		<!-- Template CSS Files  -->
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="css/magnific-popup.css" rel="stylesheet">
		<link href="css/owl.carousel.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link href="css/responsive.css" rel="stylesheet">
		
		
	</head>
	<body>
	
	<!-- 상단 메뉴  -->
	<!-- Header Section Starts -->
		<header id="header-area">
		<!-- Header Top Starts -->
			<div class="header-top">
			<!-- Nested Container Starts -->
				<div class="container clearfix text-center text-sm-left">
				<!-- Top Links Starts -->
					<ul class="list-unstyled list-inline header-links mb-0 float-sm-right">
						<li class="list-inline-item"><a href="#"><i class="fa fa-home d-block d-lg-none" title="지니북"></i><span class="d-none d-lg-block">지니북</span></a></li>
						<!-- <li class="list-inline-item"><a href="#"><i class="fa fa-heart d-block d-lg-none" title="Wish List(0)"></i><span class="d-none d-lg-block">Wish List(0)</span></a></li> -->
						<li class="list-inline-item"><a href="#"><i class="fa fa-user d-block d-lg-none" title="마이페이지"></i><span class="d-none d-lg-block">마이페이지</span></a></li>
						<li class="list-inline-item"><a href="#"><i class="fa fa-shopping-cart d-block d-lg-none" title="장바구니"></i><span class="d-none d-lg-block">장바구니</span></a></li>
						<li class="list-inline-item"><a href="#"><i class="fa fa-crosshairs d-block d-lg-none" title="결제"></i><span class="d-none d-lg-block">결제</span></a></li>
						<li class="list-inline-item"><a href="#"><i class="fa fa-unlock d-block d-lg-none" title="회원가입"></i><span class="d-none d-lg-block">회원가입</span></a></li>
						<li class="list-inline-item"><a href="#"><i class="fa fa-lock d-block d-lg-none" title="로그인"></i><span class="d-none d-lg-block">로그인</span></a></li>
					</ul>
				<!-- Top Links Ends -->
				</div>
			<!-- Nested Container Ends -->
			</div>
		<!-- Header Top Ends -->
		
		<!-- Main Header Starts -->
			<div class="main-header">
			<!-- Nested Container Starts -->
				<div class="container">
				<!-- Nested Row Starts -->
					<div class="row">
					<!-- 로고 -->
						<div class="col-xl-6 col-md-4 col-sm-12 text-center">
							<div id="logo"><a href="#"><img src="images/logo.png" title="지니북" alt="지니북" class="img-fluid" /></a></div>
						</div>
					<!-- 로고 end -->	
					<!-- 책 검색 Starts -->
						<div class="col-xl-3 col-md-4 col-sm-12">
							<div id="search">
								<div class="input-group">
								  <input type="text" class="form-control" placeholder="책검색하기">
								  <span class="input-group-btn">
									<button class="btn" type="button">
										<i class="fa fa-search"></i>
									</button>
								  </span>
								</div>
							</div>	
						</div>
					<!-- 책 검색 Ends -->
					
					<!-- 장바구니 Starts -->
						<!-- <div class="col-xl-3 col-md-4 col-sm-12">
							<div id="cart" class="btn-group btn-block">
								<button type="button" data-toggle="dropdown" class="btn btn-block dropdown-toggle">
									<i class="fa fa-shopping-cart"></i>
									<span class="d-none d-lg-inline-block">Cart:</span> 
									<span id="cart-total">2 item(s) - $340.00</span>
									<i class="fa fa-caret-down"></i>
								</button>
								<ul class="dropdown-menu dropdown-menu-right">
									<li>
										<table class="table hcart">
											<tr>
												<td class="text-center">
													<a href="product.html">
														<img src="images/product-images/hcart-thumb1.jpg" alt="image" title="image" class="img-fluid1" />
													</a>
												</td>
												<td class="text-left">
													<a href="product-full.html">
														Seeds
													</a>
												</td>
												<td class="text-right">x 1</td>
												<td class="text-right">$120.68</td>
												<td class="text-center">
													<a href="#">
														<i class="fa fa-times"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td class="text-center">
													<a href="product.html">
														<img src="images/product-images/hcart-thumb2.jpg" alt="image" title="image" class="img-fluid1" />
													</a>
												</td>
												<td class="text-left">
													<a href="product-full.html">
														Organic
													</a>
												</td>
												<td class="text-right">x 2</td>
												<td class="text-right">$240.00</td>
												<td class="text-center">
													<a href="#">
														<i class="fa fa-times"></i>
													</a>
												</td>
											</tr>
										</table>
									</li>
									<li>
										<table class="table table-bordered total">
											<tbody>
												<tr>
													<td class="text-right"><strong>Sub-Total</strong></td>
													<td class="text-left">$1,101.00</td>
												</tr>
												<tr>
													<td class="text-right"><strong>Eco Tax (-2.00)</strong></td>
													<td class="text-left">$4.00</td>
												</tr>
												<tr>
													<td class="text-right"><strong>VAT (17.5%)</strong></td>
													<td class="text-left">$192.68</td>
												</tr>
												<tr>
													<td class="text-right"><strong>Total</strong></td>
													<td class="text-left">$1,297.68</td>
												</tr>
											</tbody>
										</table>
										<p class="text-right btn-block1">
											<a href="cart.html">
												View Cart
											</a>
											<a href="#">
												Checkout
											</a>
										</p>
									</li>									
								</ul>
							</div>
						</div> -->
					<!-- Shopping Cart Ends -->
					</div>
					
				<!-- Nested Row Ends -->
				</div>
			<!-- Nested Container Ends -->
			</div>
		<!-- Main Header Ends -->
		
		<!-- Main Menu Starts -->
			<nav id="main-menu" class=" navbar navbar-expand-md rounded-0">
			<!-- Nested Container Starts -->
				<div class="container">
				<!-- Navbar Toggler Starts -->
					<button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target=".navbar-cat-collapse" aria-controls=".navbar-cat-collapse" aria-expanded="false" aria-badge="Toggle navigation">
						<span class="navbar-toggler-icon fa fa-bars"></span>
					</button>
				<!-- Navbar Toggler Ends -->
				<!-- Navbar Cat collapse Starts -->
					<div class="collapse navbar-collapse navbar-cat-collapse">
						<ul class="nav navbar-nav">
							<!-- 국내서적 start  -->
							<li class="nav-item dropdown">
								<a href="category-list.html" class="nav-link dropdown-toggle" data-toggle="dropdown">
									국내 서적
								</a>
								<div class="dropdown-menu rounded-0">
									<a href="#" class="dropdown-item">어린이</a>
									<a href="#" class="dropdown-item">청소년</a>
									<a href="#" class="dropdown-item">참고서</a>
									<a href="#" class="dropdown-item">소설/시/희곡</a> 
									<a href="#" class="dropdown-item">자기계발</a> 
									<a href="#" class="dropdown-item">사회/과학</a> 
									<a href="#" class="dropdown-item">컴퓨터/IT</a>  
								</div>
							</li>
							<!-- 국내서적 end  -->
							
							<!-- 외국서적 start -->
							<li class="nav-item dropdown">
								<a href="category-list.html" class="nav-link dropdown-toggle" data-toggle="dropdown">
									외국 서적
								</a>
								<div class="dropdown-menu rounded-0">
									<a href="#" class="dropdown-item">어린이</a>
									<a href="#" class="dropdown-item">청소년</a>
									<a href="#" class="dropdown-item">참고서</a>
									<a href="#" class="dropdown-item">소설/시/희곡</a> 
									<a href="#" class="dropdown-item">자기계발</a> 
									<a href="#" class="dropdown-item">사회/과학</a> 
									<a href="#" class="dropdown-item">컴퓨터/IT</a>  
								</div>
							</li>
							<!-- 외국서적 end -->
							
							<!-- 사용안함 -->
							<!-- <li class="nav-item dropdown">
								<a href="category-list.html" class="nav-link dropdown-toggle" data-toggle="dropdown">Televisions</a>
								<div class="dropdown-menu rounded-0">
									<div class="dropdown-inner">
										<ul class="list-unstyled">
											<li class="dropdown-header">어린이</li>
											<li><a href="#">item 1</a></li>
											<li><a href="#">item 2</a></li>
											<li><a href="#">item 3</a></li>
										</ul>										
										<ul class="list-unstyled">
											<li class="dropdown-header">청소년</li>
											<li><a href="#">item 1</a></li>
											<li><a href="#">item 2</a></li>
											<li><a href="#">item 3</a></li>
										</ul>
										<ul class="list-unstyled">
											<li class="dropdown-header">참고서</li>
											<li><a href="#">item 1</a></li>
											<li><a href="#">item 2</a></li>
											<li><a href="#">item 3</a></li>
										</ul>
									</div>
								</div>
							</li> -->
							<!-- 사용안함  -->
							
							<li class="nav-item"><a href="category-list.html" class="nav-link">공지사항</a></li>
							<li class="nav-item"><a href="category-list.html" class="nav-link">자유게시판</a></li>
							
							<!-- 페이지 직접 가기   -->
							<li class="nav-item dropdown">
								<a href="category-list.html" class="nav-link dropdown-toggle" data-toggle="dropdown">
									페이지 직접 가기 
								</a>
								<div class="dropdown-menu rounded-0">
									<a href="home.jsp" class="dropdown-item">Home</a>
									<a href="about.html" class="dropdown-item">About</a>
									<a href="category-list.html" class="dropdown-item">Category List</a>
									<a href="category-grid.html" class="dropdown-item">Category Grid</a>
									<a href="product.html" class="dropdown-item">Product</a>
									<a href="product-full.html" class="dropdown-item">Product Full Width</a>
									<a href="cart.html" class="dropdown-item">Cart</a>
									<a href="login.html" class="dropdown-item">Login</a>
									<a href="compare.html" class="dropdown-item">Compare Products</a>
									<a href="typography.html" class="dropdown-item">Typography</a>
									<a href="register.html" class="dropdown-item">Register</a>
									<a href="contact.html" class="dropdown-item">Contact</a>
									<a href="404.html" class="dropdown-item">404</a>
								</div>
							</li>
							<!-- 페이지 직접 가기   -->
							
						</ul>
					</div>
				<!-- Navbar Cat collapse Ends -->
				</div>
			<!-- Nested Container Ends -->
			</nav>
		<!-- Main Menu Ends -->
		</header>
	<!-- Header Section Ends -->
	<!-- 상단 메뉴  -->
	
	
	
	
	
	<!-- Main Container Starts -->
		<div id="main-container-home" class="container">
		<!-- Nested Row Starts -->
			<div class="row">
			
			<!-- 좌측 네비게이션 메뉴  -->
			<!-- Sidebar Starts -->
				<div class="col-md-3 col-sm-12">
				<!-- Categories Links Starts -->
					<h3 class="side-heading">국내도서</h3>
					<div class="list-group categories">
						<a href="#" class="list-group-item">
							<i class="fa fa-angle-right"></i>
							어린이
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-angle-right"></i>
							청소년
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-angle-right"></i>
							참고서
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-angle-right"></i>
							소설/시/희곡
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-angle-right"></i>
							자기계발
						</a>
						<a href="#" class="list-group-item">
							<i class="fa fa-angle-right"></i>
							사회/과학
						</a>
						<a href="#" class="list-group-item">
							<i class="fa #"></i>
							컴퓨터/IT
						</a>
					</div>
				<!-- Categories Links Ends -->
				<!-- Special Products Starts -->
					<h3 class="side-heading">Specials</h3>
					<ul class="side-products-list">
					<!-- Special Product #1 Starts -->
						<li class="clearfix">
							<img src="images/product-images/spl-product-img1.jpg" alt="Special product" class="img-fluid" />
							<h5><a href="#">이벤트 도서 1</a></h5>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
						</li>
					<!-- Special Product #1 Ends -->
					<!-- Special Product #2 Starts -->
						<li class="clearfix">
							<img src="images/product-images/spl-product-img2.jpg" alt="Special product" class="img-fluid" />
							<h5><a href="#">이벤트 도서 2</a></h5>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
						</li>
					<!-- Special Product #2 Ends -->
					<!-- Special Product #3 Starts -->
						<li class="clearfix">
							<img src="images/product-images/spl-product-img3.jpg" alt="Special product" class="img-fluid" />
							<h5><a href="#">이벤트 도서 3</a></h5>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
						</li>
					<!-- Special Product #3 Ends -->
					<!-- Special Product #4 Starts -->
						<li class="clearfix">
							<img src="images/product-images/spl-product-img1.jpg" alt="Special product" class="img-fluid" />
							<h5><a href="#">이벤트 도서 4</a></h5>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
						</li>
					<!-- Special Product #4 Ends -->
					<!-- Special Product #5 Starts -->
						<li class="clearfix">
							<img src="images/product-images/spl-product-img2.jpg" alt="Special product" class="img-fluid" />
							<h5><a href="#">이벤트 도서 5</a></h5>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
						</li>
					<!-- Special Product #5 Ends -->
					</ul>
				<!-- Special Products Ends -->
				<!-- Banner #1 Starts -->
					<p><img src="images/banners/side-banner1.jpg" alt="Side Banner" class="img-fluid" /></p>
				<!-- Banner #1 Ends -->
                
				</div>
			<!-- Sidebar Ends -->
			
			
			<!-- Primary Content Starts -->
				<div class="col-md-9 col-sm-12">
				<!-- Slider Section Starts -->
					<div class="slider">
						<div id="main-carousel" class="carousel slide carousel-fade" data-ride="carousel">
						<!-- Wrapper For Slides Starts -->
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="images/slider-imgs/slide1-img.jpg" alt="Slider" class="img-fluid" />
								</div>
								<div class="carousel-item">
									<img src="images/slider-imgs/slide2-img.jpg" alt="Slider" class="img-fluid" />
								</div>
							</div>
						<!-- Wrapper For Slides Ends -->
						<!-- Controls Starts -->
							<a class="carousel-control-prev animation" href="#main-carousel" role="button" data-slide="prev">
								<span class="fa fa-3x fa-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a>
							<a class="carousel-control-next animation" href="#main-carousel" role="button" data-slide="next">
								<span class="fa fa-3x fa-chevron-right" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>
						<!-- Controls Ends -->
						</div>	
					</div>
				<!-- Slider Section Ends -->
				
				<!-- 2 Column Banners Starts -->
					<!-- <div class="col2-banners">
						<ul class="row list-unstyled text-center">
							<li class="col-sm-8">
								<img src="images/banners/2col-banner1.jpg" alt="banners" class="img-fluid" />
							</li>
							<li class="col-sm-4">
								<img src="images/banners/2col-banner2.jpg" alt="banners" class="img-fluid" />
							</li>
						</ul>
					</div> -->
				<!-- 2 Column Banners Ends -->
				
				<!-- Latest Products Starts -->
					<section class="product-carousel">
					<!-- Heading Starts -->
						<h2 class="product-head">신간 서적</h2>
					<!-- Heading Ends -->
					<!-- Products Row Starts -->
						<div class="row">
							<div class="col-12">
							<!-- Product Carousel Starts -->
								<div id="owl-product" class="owl-carousel">
								<!-- Product #1 Starts -->
									<div class="item">
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/1.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #1 Ends -->
								<!-- Product #2 Starts -->
									<div class="item">
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/2.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #2 Ends -->
								<!-- Product #3 Starts -->
									<div class="item">	
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/3.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #3 Ends -->
								<!-- Product #4 Starts -->
									<div class="item">	
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/4.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #4 Ends -->
								<!-- Product #5 Starts -->
									<div class="item">
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/5.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #5 Ends -->
								<!-- Product #6 Starts -->
									<div class="item">
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/6.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #6 Ends -->
								<!-- Product #7 Starts -->
									<div class="item">	
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/7.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #7 Ends -->
								<!-- Product #8 Starts -->
									<div class="item">	
										<div class="product-col">
											<div class="image">
												<img src="images/product-images/8.jpg" alt="product" class="img-fluid" />
											</div>
											<div class="caption">
												<h4><a href="product.html">Digital Electro Goods</a></h4>
												<div class="description">
													We are so lucky living in such a wonderful time. Our almost unlimited ...
												</div>
												<div class="price">
													<span class="price-new">$199.50</span> 
													<span class="price-old">$249.50</span>
												</div>
												<div class="cart-button">
													<button type="button" class="btn btn-cart">
														Add to cart
														<i class="fa fa-shopping-cart"></i> 
													</button>									
												</div>
											</div>
										</div>
									</div>
								<!-- Product #8 Ends -->
								</div>
							<!-- Product Carousel Ends -->
							</div>
						</div>
					<!-- Products Row Ends -->
					</section>
				<!-- Latest Products Ends -->
				
				<!-- Specials Products Starts -->
					<section class="products-list">			
					<!-- Heading Starts -->
						<h2 class="product-head">베스트셀러</h2>
					<!-- Heading Ends -->
					<!-- Products Row Starts -->
						<div class="row">
						<!-- Product #1 Starts -->
							<div class="col-md-4 col-sm-6 col-12">
								<div class="product-col">
									<div class="image">
										<img src="images/product-images/9.jpg" alt="product" class="img-fluid" />
									</div>
									<div class="caption">
										<h4>
											<a href="product-full.html">Digital Electro Goods</a>
										</h4>
										<div class="description">
											We are so lucky living in such a wonderful time. Our almost unlimited ...
										</div>
										<div class="price">
											<span class="price-new">$199.50</span> 
											<span class="price-old">$249.50</span>
										</div>
										<div class="cart-button">
											<button type="button" class="btn btn-cart">
												Add to cart
												<i class="fa fa-shopping-cart"></i> 
											</button>									
										</div>
									</div>
								</div>
							</div>
						<!-- Product #1 Ends -->
						<!-- Product #2 Starts -->
							<div class="col-md-4 col-sm-6 col-12">
								<div class="product-col">
									<div class="image">
										<img src="images/product-images/10.jpg" alt="product" class="img-fluid" />
									</div>
									<div class="caption">
										<h4>
											<a href="product-full.html">Digital Electro Goods</a>
										</h4>
										<div class="description">
											We are so lucky living in such a wonderful time. Our almost unlimited ...
										</div>
										<div class="price">
											<span class="price-new">$199.50</span> 
											<span class="price-old">$249.50</span>
										</div>
										<div class="cart-button">
											<button type="button" class="btn btn-cart">
												Add to cart
												<i class="fa fa-shopping-cart"></i> 
											</button>									
										</div>
									</div>
								</div>
							</div>
						<!-- Product #2 Ends -->
						<!-- Product #3 Starts -->
							<div class="col-md-4 col-sm-6 col-12">
								<div class="product-col">
									<div class="image">
										<img src="images/product-images/11.jpg" alt="product" class="img-fluid" />
									</div>
									<div class="caption">
										<h4>
											<a href="product-full.html">Digital Electro Goods</a>
										</h4>
										<div class="description">
											We are so lucky living in such a wonderful time. Our almost unlimited ...
										</div>
										<div class="price">
											<span class="price-new">$199.50</span> 
											<span class="price-old">$249.50</span>
										</div>
										<div class="cart-button">
											<button type="button" class="btn btn-cart">
												Add to cart
												<i class="fa fa-shopping-cart"></i> 
											</button>									
										</div>
									</div>
								</div>
							</div>
						<!-- Product #3 Ends -->
						</div>
					<!-- Products Row Ends -->
					</section>
				<!-- Specials Products Ends -->
				</div>
			<!-- Primary Content Ends -->
			</div>
		<!-- Nested Row Ends -->
		</div>
	<!-- Main Container Ends -->
	<!-- Footer Section Starts -->
		<footer id="footer-area">
		<!-- Footer Links Starts -->
			<div class="footer-links">
			<!-- Container Starts -->
				<div class="container text-center text-sm-left">
				<!-- Nested Row Starts -->
					<div class="row">
					<!-- Information Links Starts -->
						<div class="col-lg-2 col-md-3 col-sm-3">
							<h5>Information</h5>
							<ul class="list-unstyled">
								<li><a href="about.html">About Us</a></li>
								<li><a href="#">Delivery Information</a></li>
								<li><a href="#">Privacy Policy</a></li>
								<li><a href="#">Terms &amp; Conditions</a></li>
							</ul>
						</div>
					<!-- Information Links Ends -->
					<!-- My Account Links Starts -->
						<div class="col-lg-2 col-md-3 col-sm-3">
							<h5>My Account</h5>
							<ul class="list-unstyled">
								<li><a href="#">My orders</a></li>
								<li><a href="#">My merchandise returns</a></li>
								<li><a href="#">My credit slips</a></li>
								<li><a href="#">My addresses</a></li>
								<li><a href="#">My personal info</a></li>
							</ul>
						</div>
					<!-- My Account Links Ends -->					
					<!-- Customer Service Links Starts -->
						<div class="col-lg-2 col-md-3 col-sm-3">
							<h5>Service</h5>
							<ul class="list-unstyled">
								<li><a href="contact.html">Contact Us</a></li>
								<li><a href="#">Returns</a></li>
								<li><a href="#">Site Map</a></li>
								<li><a href="#">Affiliates</a></li>
								<li><a href="#">Specials</a></li>
							</ul>
						</div>
					<!-- Customer Service Links Ends -->
					<!-- Follow Us Links Starts -->
						<div class="col-lg-2 col-md-3 col-sm-3">
							<h5>Follow Us</h5>
							<ul class="list-unstyled">
								<li><a href="#">Facebook</a></li>
								<li><a href="#">Twitter</a></li>
								<li><a href="#">RSS</a></li>
								<li><a href="#">YouTube</a></li>
							</ul>
						</div>
					<!-- Follow Us Links Ends -->
					<!-- Contact Us Starts -->
						<div class="col-lg-4 col-sm-12 last">
							<h5>Contact Us</h5>
							<ul class="list-unstyled">
								<li>My Company</li>
								<li>
									1247 LB Nagar Road, Hyderabad, Telangana - 35
								</li>
								<li>
									Email: <a href="#">info@demolink.com</a>
								</li>								
							</ul>
							<h4 class="lead">
								Tel: <span>1(234) 567-9842</span>
							</h4>
						</div>
					<!-- Contact Us Ends -->
					</div>
				<!-- Nested Row Ends -->
				</div>
			<!-- Container Ends -->
			</div>
		<!-- Footer Links Ends -->
		<!-- Copyright Area Starts -->
			<div class="copyright">
			<!-- Container Starts -->
				<div class="container clearfix text-center text-md-left">
				<!-- Starts -->
					<p class="float-md-left">
						&copy; 2019 Electro Shoppe Stores. Designed By <a href="http://sainathchillapuram.com">Sainath Chillapuram</a>
					</p>
				<!-- Ends -->
				<!-- Payment Gateway Links Starts -->
					<ul class="float-md-right list-unstyled list-inline text-center text-md-right">
						<li class="list-inline-item">
							<img src="images/payment-icon/cirrus.png" alt="PaymentGateway" />
						</li>
						<li class="list-inline-item">
							<img src="images/payment-icon/paypal.png" alt="PaymentGateway" />
						</li>
						<li class="list-inline-item">
							<img src="images/payment-icon/visa.png" alt="PaymentGateway" />
						</li>
						<li class="list-inline-item">
							<img src="images/payment-icon/mastercard.png" alt="PaymentGateway" />
						</li>
						<li class="list-inline-item">
							<img src="images/payment-icon/americanexpress.png" alt="PaymentGateway" />
						</li>
					</ul>
				<!-- Payment Gateway Links Ends -->
				</div>
			<!-- Container Ends -->
			</div>
		<!-- Copyright Area Ends -->
		</footer>
	<!-- Footer Section Ends -->
	<!-- Template JS Files -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/custom.js"></script>	
	</body>
</html>