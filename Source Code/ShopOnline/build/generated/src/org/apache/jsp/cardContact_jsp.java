package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cardContact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/topbar.jsp");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Sneaker Store</title>\n");
      out.write("    <!-- Site Icons -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon.png\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/card.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/responsive.css\">\n");
      out.write("    <script src=\"js/fontAwesome.js\"></script>\n");
      out.write("    \n");
      out.write("    <!-- Bootstrap 5 -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
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
      out.write("\n");
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
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- Start Shop Page  -->\n");
      out.write("    <div class=\"shop-box-inner\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"all-title-box\" style=\"margin-top: 60px;\">\n");
      out.write("                <div aria-label=\"breadcrumb\">\n");
      out.write("                    <ul class=\"breadcrumb\">\n");
      out.write("                        <li class=\"breadcrumb-item\"><a href=\"HomeController\">Home</a></li>\n");
      out.write("                        <li class=\"breadcrumb-item\"><a href=\"CartController\">Card</a></li>\n");
      out.write("                        <li class=\"breadcrumb-item active\" aria-current=\"page\">Card Contact</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Start Cart  -->\n");
      out.write("            <div class=\"cart-box-main\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-5 col-lg-5 mb-3\">\n");
      out.write("                            <div class=\"checkout-address\">\n");
      out.write("                                <div class=\"title-top\">\n");
      out.write("                                    <h4>Billing address</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <form action=\"\">\n");
      out.write("                                    <div class=\"mb-3 mt-3\">\n");
      out.write("                                        <label for=\"fullName\">Full name *</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"firstName\" name=\"name_receiver\" value=\"\" required>\n");
      out.write("                                        <div class=\"invalid-feedback\"> Valid full name is required. </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"phone\">Phone Number *</label>\n");
      out.write("                                        <input type=\"tel\" class=\"form-control\" id=\"phone\" name=\"phone\" required>\n");
      out.write("                                        <div class=\"invalid-feedback\" style=\"width: 100%;\"> Your phone is required. </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"email\">Email Address *</label>\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" required>\n");
      out.write("                                        <div class=\"invalid-feedback\"> Please enter a valid email address for shipping updates. </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"address\">Address *</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" placeholder=\"\" required>\n");
      out.write("                                        <div class=\"invalid-feedback\"> Please enter your shipping address. </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"address\">Note </label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" placeholder=\"\" required>\n");
      out.write("                                        <div class=\"invalid-feedback\"> Please enter your shipping address. </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-7 col-lg-7 mb-3\">\n");
      out.write("                            <div class=\"order-box\">\n");
      out.write("                                <div class=\"title-top\">\n");
      out.write("                                    <h4>Your order</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"order-ls\" style=\"margin-top: 20px;\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Product</td>\n");
      out.write("                                                <td>Quantity</td>\n");
      out.write("                                                <td>Price</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td class=\"d-flex flex-row me-3\">\n");
      out.write("                                                    <div class=\"image\">\n");
      out.write("                                                        <img src=\"images/2.jpg\" class=\"img-fluid\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"d-flex flex-column\">\n");
      out.write("                                                        <span><strong>Wmns Air Jordan 1</strong></span>\n");
      out.write("                                                        <span>Color</span>\n");
      out.write("                                                        <span>Size</span>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <input type=\"text\" value=\"1\" disabled>\n");
      out.write("                                                </td>\n");
      out.write("                                                <td>300.000<i class=\"fa-solid fa-dong-sign\"></i></td>\n");
      out.write("                                                <td><i class=\"fa-regular fa-trash-can remove-icon\"></i></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td style=\"color: #d33b33; font-size: 20px; font-weight: 600;\">Total:</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>300.000<i class=\"fa-solid fa-dong-sign\"></i></td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"payment-box mt-4\">\n");
      out.write("                                <div class=\"title-top\">\n");
      out.write("                                    <h5>Payment</h5>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row payment\">\n");
      out.write("                                    <div class=\"col-lg-6 payment-ls\">\n");
      out.write("                                        <p><small>Select a payment method</small></p>\n");
      out.write("                                        <ul class=\"d-flex flex-wrap\">\n");
      out.write("                                            <li id=\"pm-sl\">\n");
      out.write("                                                <img src=\"images/payment-icon/cod.png\" class=\"image\">\n");
      out.write("                                                <i class=\"fa-solid fa-circle-check mark-icon\"></i>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"\">\n");
      out.write("                                                    <img src=\"images/payment-icon/visa.png\" class=\"image\">\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"\">\n");
      out.write("                                                    <img src=\"images/payment-icon/jcb.png\" class=\"image\">\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"\">\n");
      out.write("                                                    <img src=\"images/payment-icon/master.png\" class=\"image\">\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"\">\n");
      out.write("                                                    <img src=\"images/payment-icon/PayPal.png\" class=\"image\">\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"\">\n");
      out.write("                                                    <img src=\"images/payment-icon/citibank.png\" class=\"image\">\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                        <script>\n");
      out.write("                                            var mark = document.querySelector(\".mark-icon\");\n");
      out.write("                                            var selectBtn = document.querySelector(\"#pm-sl\");\n");
      out.write("\n");
      out.write("                                            selectBtn.addEventListener(\"click\", () => {\n");
      out.write("                                                mark.classList.toggle(\"check\");\n");
      out.write("                                            })\n");
      out.write("                                        </script>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"input-group\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter discount code\">\n");
      out.write("                                            <button class=\"btn btn-danger\" type=\"button\">Apply</button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"add-comp why-text\">\n");
      out.write("                                            <a href=\"#\" class=\"ms-auto btn\">Place Order</a>\n");
      out.write("                                            <a href=\"CartController\" class=\"ml-auto btn\">Change</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- End Cart -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- End Shop Page -->\n");
      out.write("    \n");
      out.write("    ");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <div class=\"footer-main\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-sm-12\">\r\n");
      out.write("                    <div class=\"footer-widget\">\r\n");
      out.write("                        <h4>About ThewayShop</h4>\r\n");
      out.write("                        <p>TheWay shoes were born based on the shop owner's love of Nike shoes, Adidas shoes, Vans shoes... by the enchanting beauty of these trendy shoe models!\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"https://www.facebook.com/bibeoauthentic97\"><i class=\"fa-brands fa-facebook-square\"></i></a></li>\r\n");
      out.write("                            <li><a href=\"https://www.instagram.com/bibeo.authentic/?fbclid=IwAR2o3TdF84Ha1U-idkHYnu1vte-pbUbaRrSsvjl3ClZBPLqk67Wb19-VZss\"><i class=\"fa-brands fa-instagram\"></i></a></li>\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-sm-12\">\r\n");
      out.write("                    <div class=\"footer-link\">\r\n");
      out.write("                        <h4>The Brand</h4>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">Nike</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">Vans</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">Adidas</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">New Blance</a>\r\n");
      out.write("                            </li>                                \r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-sm-12\">\r\n");
      out.write("                    <div class=\"footer-link-contact\">\r\n");
      out.write("                        <h4>Contact Us</h4>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <p><i class=\"fas fa-map-marker-alt\"></i>103 phố Hồ Đắc Di , phường Nam Đồng, <br> quận Đống Đa Hanoi, Vietnam 100000</p>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <p><i class=\"fas fa-phone-square\"></i>Phone: <a href=\"tel:+091 978 55 48\">091 978 55 48</a></p>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <p><i class=\"fas fa-envelope\"></i>Email: <a href=\"mailto:bi1508.97@gmail.com\">bi1508.97@gmail.com</a></p>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("<button id=\"back-to-top\" title=\"Go to top\"><i class=\"fa-solid fa-angles-up\"></i></button>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/tooltip.js\"></script>\r\n");
      out.write("<script src=\"js/scrollTop.js\"></script>\r\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
}
