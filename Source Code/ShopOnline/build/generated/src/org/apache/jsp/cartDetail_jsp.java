package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cartDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/topbar.jsp");
    _jspx_dependants.add("/header.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<!-- Basic -->\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Mobile Metas -->\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Site Metas -->\r\n");
      out.write("    <title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>\r\n");
      out.write("    <meta name=\"keywords\" content=\"\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Site Icons -->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon.png\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap 5 -->\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <!-- Site CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("    <!-- Responsive CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/custom.css\">\r\n");
      out.write("\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<div class=\"main-top\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"text-center\">\r\n");
      out.write("                <div class=\"text-slid-box\">\r\n");
      out.write("                    <div id=\"myCarousel\" class=\"carousel slide\" data-bs-ride=\"carousel\">\r\n");
      out.write("                        <ul style=\"margin: 0;\" class=\"offer-box carousel-inner\">\r\n");
      out.write("                            <li class=\"carousel-item active\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 10%! Shop Now Man\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 50% - 80% off on Fashion\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 20% off Entire Purchase Promo code: offT20\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 50%! Shop Now\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 10%! Shop Now Man\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 50% - 80% off on Fashion\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> 20% off Entire Purchase Promo code: offT20\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"carousel-item\">\r\n");
      out.write("                                <i class=\"fab fa-opencart\"></i> Off 50%! Shop Now\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\" class=\"bg-light\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <!-- Start Navigation -->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bootsnav\">\r\n");
      out.write("                <!-- Start Header Navigation -->\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbar-menu\" aria-controls=\"navbars-rs-food\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"home\"><img src=\"images/logo.png\" class=\"logo\" alt=\"\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbar-menu\">\r\n");
      out.write("                    <!-- Start Top Search -->\r\n");
      out.write("                    <form action=\"action\">\r\n");
      out.write("                        <div class=\"top-search\">\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <span class=\"input-group-text\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("                                <input type=\"search\" class=\"form-control\"  placeholder=\"Search...\">\r\n");
      out.write("                                <span class=\"input-group-text close-search\"><i class=\"fa fa-times\"></i></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <!-- End Top Search -->\r\n");
      out.write("                    <ul id=\"page-header\" class=\"nav navbar-nav ms-auto\">\r\n");
      out.write("                        <li class=\"nav-item active\"><a class=\"nav-link\" href=\"home\" title=\"Home\">Home</a></li>\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"blog\" title=\"Blogs\">Blogs</a></li>                       \r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"ProductController\" title=\"Products\">Product</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"account-header\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav\">\r\n");
      out.write("                        <li class=\"search\">\r\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-search\"></i></a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"side-menu\">\r\n");
      out.write("                            <a href=\"CartController\" title=\"Cart\">\r\n");
      out.write("                                <i class=\"fa fa-shopping-bag\"></i>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"account\">\r\n");
      out.write("                            ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End Navigation -->\r\n");
      out.write("    </header>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    const navMenu = document.getElementById(\"navbar-menu\"),\r\n");
      out.write("            searchBtn = document.querySelector(\".search\"),\r\n");
      out.write("            closeBtn = document.querySelector(\".close-search\"),\r\n");
      out.write("            headSpan = document.getElementById(\"page-header\"),\r\n");
      out.write("            searchSpan = document.querySelector(\".top-search\");\r\n");
      out.write("\r\n");
      out.write("    searchBtn.onclick = function () {\r\n");
      out.write("        navMenu.removeChild(headSpan);\r\n");
      out.write("        navMenu.appendChild(searchSpan);\r\n");
      out.write("        searchSpan.style.display = \"block\";\r\n");
      out.write("        searchBtn.style.display = \"none\";\r\n");
      out.write("    };\r\n");
      out.write("    closeBtn.onclick = function () {\r\n");
      out.write("        navMenu.appendChild(headSpan);\r\n");
      out.write("        navMenu.removeChild(searchSpan);\r\n");
      out.write("        searchBtn.style.display = \"block\";\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    var prevScrollpos = window.pageYOffset;\r\n");
      out.write("\r\n");
      out.write("    window.onscroll = function () {\r\n");
      out.write("        var currentScrollPos = window.pageYOffset;\r\n");
      out.write("        if (currentScrollPos === 0) {\r\n");
      out.write("            document.getElementById(\"header\").style.top = \"37px\";\r\n");
      out.write("        } else if (prevScrollpos > currentScrollPos) {\r\n");
      out.write("            document.getElementById(\"header\").style.top = \"0px\";\r\n");
      out.write("        } else {\r\n");
      out.write("            document.getElementById(\"header\").style.top = \"-60px\";\r\n");
      out.write("        }\r\n");
      out.write("        prevScrollpos = currentScrollPos;\r\n");
      out.write("    };\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <!-- Start Top Search -->\r\n");
      out.write("    <div class=\"top-search\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("                <span class=\"input-group-addon\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("                <span class=\"input-group-addon close-search\"><i class=\"fa fa-times\"></i></span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End Top Search -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Start All Title Box -->\r\n");
      out.write("    <div class=\"all-title-box\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <h2>Cart Detail</h2>\r\n");
      out.write("                    <ul class=\"breadcrumb\">\r\n");
      out.write("                        <li class=\"breadcrumb-item\"><a href=\"HomeController\">Shop</a></li>\r\n");
      out.write("                        <li class=\"breadcrumb-item active\">Cart Detail</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End All Title Box -->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"wishlist-box-main\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <div class=\"table-main table-responsive\">\r\n");
      out.write("                        <table class=\"table\">\r\n");
      out.write("                            <thead>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>Product Name</th>\r\n");
      out.write("                                    <th>Images</th>\r\n");
      out.write("                                    <th>Unit Price </th>\r\n");
      out.write("                                    <th>Quantity</th>\r\n");
      out.write("                                    <th>Update</th>\r\n");
      out.write("                                    <th>Buy Now</th>\r\n");
      out.write("                                    <th>Remove</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                        <div class=\"col-md-12 col-lg-12\">\r\n");
      out.write("                            <div class=\"order-box\">\r\n");
      out.write("                                <div class=\"title-left\">\r\n");
      out.write("                                    <h3>Your order</h3>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"d-flex gr-total\">\r\n");
      out.write("                                    <h5>Grand Total</h5>\r\n");
      out.write("                                    <div class=\"ml-auto h5\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <hr> \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"add-to-btn\">\r\n");
      out.write("                            <div class=\"add-comp\">\r\n");
      out.write("                                <a class=\"btn hvr-hover\" href=\"ProductController\">Products List</a>\r\n");
      out.write("                                <a class=\"btn hvr-hover\" href=\"CartContact\">Cart Contact</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End Wishlist -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Start Instagram Feed  -->\r\n");
      out.write("    <div class=\"instagram-box\">\r\n");
      out.write("        <div class=\"main-instagram owl-carousel owl-theme\">\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-01.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-02.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-03.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-04.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-05.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-06.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-07.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-08.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-09.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("                <div class=\"ins-inner-box\">\r\n");
      out.write("                    <img src=\"images/instagram-img-05.jpg\" alt=\"\" />\r\n");
      out.write("                    <div class=\"hov-in\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End Instagram Feed  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Start Footer  -->\r\n");
      out.write("    <footer>\r\n");
      out.write("        <div class=\"footer-main\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-4 col-md-12 col-sm-12\">\r\n");
      out.write("                        <div class=\"footer-widget\">\r\n");
      out.write("                            <h4>About ThewayShop</h4>\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\r\n");
      out.write("                                </p>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fab fa-facebook\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fab fa-twitter\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fab fa-linkedin\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fab fa-google-plus\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-rss\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fab fa-pinterest-p\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fab fa-whatsapp\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-4 col-md-12 col-sm-12\">\r\n");
      out.write("                        <div class=\"footer-link\">\r\n");
      out.write("                            <h4>Information</h4>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Customer Service</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Our Sitemap</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Terms &amp; Conditions</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Delivery Information</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-4 col-md-12 col-sm-12\">\r\n");
      out.write("                        <div class=\"footer-link-contact\">\r\n");
      out.write("                            <h4>Contact Us</h4>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <p><i class=\"fas fa-map-marker-alt\"></i>Address: Michael I. Days 3756 <br>Preston Street Wichita,<br> KS 67213 </p>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <p><i class=\"fas fa-phone-square\"></i>Phone: <a href=\"tel:+1-888705770\">+1-888 705 770</a></p>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <p><i class=\"fas fa-envelope\"></i>Email: <a href=\"mailto:contactinfo@gmail.com\">contactinfo@gmail.com</a></p>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("    <!-- End Footer  -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Start copyright  -->\r\n");
      out.write("    <div class=\"footer-copyright\">\r\n");
      out.write("        <p class=\"footer-company\">All Rights Reserved. &copy; 2018 <a href=\"#\">ThewayShop</a> Design By :\r\n");
      out.write("            <a href=\"https://html.design/\">html design</a></p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End copyright  -->\r\n");
      out.write("\r\n");
      out.write("    <a href=\"#\" id=\"back-to-top\" title=\"Back to top\" style=\"display: none;\">&uarr;</a>\r\n");
      out.write("\r\n");
      out.write("    <!-- ALL JS FILES -->\r\n");
      out.write("    <script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- ALL PLUGINS -->\r\n");
      out.write("    <script src=\"js/jquery.superslides.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap-select.js\"></script>\r\n");
      out.write("    <script src=\"js/inewsticker.js\"></script>\r\n");
      out.write("    <script src=\"js/bootsnav.js.\"></script>\r\n");
      out.write("    <script src=\"js/images-loded.min.js\"></script>\r\n");
      out.write("    <script src=\"js/isotope.min.js\"></script>\r\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"js/baguetteBox.min.js\"></script>\r\n");
      out.write("    <script src=\"js/form-validator.min.js\"></script>\r\n");
      out.write("    <script src=\"js/contact-form-script.js\"></script>\r\n");
      out.write("    <script src=\"js/custom.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userlogged eq null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <a href=\"login\" title=\"Login\"><i class=\"fa fa-user\"></i></a>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userlogged ne null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <a href=\"profileUser?userid=1");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" style=\"border-left: 2px solid #d33b33;\">\r\n");
        out.write("                                        <i class=\"fa-solid fa-circle-user\"></i> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userlogged.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("                                    </a>\r\n");
        out.write("                                    <a href=\"logout\" style=\"border-left: 2px solid #d33b33;\"><i class=\"fa-solid fa-power-off\"></i></a>\r\n");
        out.write("                                    <a href=\"#\"><i class=\"fa-solid fa-clipboard-list fa-lg\"></i></a>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("carts");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                    <tr>\r\n");
          out.write("                                    <td class=\"name-pr\">\r\n");
          out.write("                                        <a class=\"link-profile\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts.product_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                    <td class=\"thumbnail-img\">\r\n");
          out.write("                                        <img class=\"img-fluid\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts.url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\" />\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                    <td class=\"price-pr\">\r\n");
          out.write("                                        <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts.unit_price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                        <form action=\"UpdateCartController\" method=\"POST\">\r\n");
          out.write("                                            <td class=\"quantity-box\">\r\n");
          out.write("                                                <input type=\"hidden\" name=\"id\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts.item_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                                <div class=\"form-group quantity-box\">\r\n");
          out.write("                                                    <input class=\"form-control\" name=\"qty\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" min=\"0\" max=\"20\" type=\"number\" style=\"height: 7vh; margin-top: 2vh;\">                                           \r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </td>\r\n");
          out.write("                                            <td class=\"add-pr\">\r\n");
          out.write("                                                <input type=\"submit\" class=\"btn btn-success\" value=\"Update\" style=\"height: 6.5vh;\"/>\r\n");
          out.write("                                            </td>\r\n");
          out.write("                                        </form>\r\n");
          out.write("                                    <td class=\"add-pr\">\r\n");
          out.write("                                        <a class=\"btn btn-success\" href=\"CartContact\">Buy Now</a>\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                    <td class=\"add-pr\">\r\n");
          out.write("                                       <a class=\"btn btn-success\" href=\"DeleteCartController?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carts.item_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Delete</a>\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                    \r\n");
          out.write("                                </tr>\r\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
