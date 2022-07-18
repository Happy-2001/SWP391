<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-lg-3 menu-bar">
    <div class="menu">
        <ul class="menu-links">
            <li class="nav-link">
                <a href="/ShopOnline/admin/dashboard">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-chart-simple fa-xl"></i>
                    </span>
                    <span class="text nav-text">Dashboard</span>
                </a>
            </li>

            <li class="nav-link">
                <a class="${OrdersActive}" href="/ShopOnline/admin/MyOrderController">
                    <span class=" nav-link-icon">
                        <i class="fa-solid fa-receipt <c:if test="${OrdersActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Orders</span>
                </a>
            </li>

            <li class="nav-link">
                <a class="${ProductsActive}" href="/ShopOnline/listproduct">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-box <c:if test="${ProductsActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Products</span>
                </a>
            </li>

            <li class="nav-link">
                <a class="${CustomersActive}" href="/ShopOnline/admin/CusController">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-user-group <c:if test="${CustomersActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Customers</span>
                </a>
            </li>

            <li class="nav-link">
                <a class="${ChatsActive}" href="/ShopOnline/message">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-envelope <c:if test="${ChatsActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Chats</span>
                    <!--<span class="badge bg-success rounded-circle ms-auto">1</span>-->
                </a>
            </li>

            <li class="nav-link">
                <a class="${FeedbackActive}" href="FeedbackAd?act=view">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-comment-dots <c:if test="${FeedbackActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Feedback</span>
                </a>
            </li>

            <li class="nav-link">
                <a class="${UserListActive}" href="/ShopOnline/admin/UserList">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-circle-user <c:if test="${UserListActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">UserList</span>
                </a>
            </li>

            <li class="nav-link">
                <a class="${SuppliersActive}" href="SuppliersController">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-truck-arrow-right <c:if test="${SuppliersActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Suppliers</span>
                </a>
            </li>
            <li class="nav-link">
                <a class="${ShipperActive}" href="/ShopOnline/admin/ShipperController">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-circle-user <c:if test="${AccountsActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Shipper</span>
                </a>
            </li>
            <li class="nav-link">
                <a class="${ManageSliderActive}" href="/ShopOnline/admin/slider">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-images <c:if test="${ManageSliderActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Manage Slider</span>

                </a>
            </li>
            <li class="nav-link">
                <a class="${PostManagerActive}" href="PostMan">
                    <span class="nav-link-icon">
                        <i class="fa-solid fa-sliders <c:if test="${PostManagerActive ne 'active'}">fa-xl</c:if>"></i>
                    </span>
                    <span class="text nav-text">Post Manager</span>

                </a>
            </li>
        </ul>
    </div>
</div>