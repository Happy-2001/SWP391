-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2022 at 05:12 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `authority`
--

CREATE TABLE `authority` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `authority`
--

INSERT INTO `authority` (`id`, `name`) VALUES
(1, 'Admin'),
(2, 'Customer'),
(3, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `blog_id` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `noidung` longtext NOT NULL,
  `User_Account_user_id` int(11) NOT NULL,
  `category_blog_id` int(11) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`blog_id`, `create_date`, `content`, `description`, `noidung`, `User_Account_user_id`, `category_blog_id`, `img`) VALUES
(1, '2021-06-10', '<b>Bí kíp săn deal 1đ, 1K</b>', 'Như mình có nói ở phần trước: “Săn sale là một nghệ thuật, người săn sale là một nghệ sĩ”. Để thành nghệ sĩ săn sale thực thụ thì bạn cần nắm vững các bước để săn sale. Sau đó bạn phải luyện tập thật nhiều để nhanh hơn 99% người còn lại và dành chiến thắng trong cuộc chiến săn sale này.', '<em><i>– Sản phẩm flash sale 1đ-1k… nói chung là sản phẩm giá rẻ, deal hủy diệt sẽ nằm ở trên trang flash sale của Lazada. Xem tại trang này ⇒<u> http://go.bgg.zone/LFvnrx</u></i></em></br></br>\r\nBạn mở các khung giờ sắp mở bán để chọn deal cần mua như hình. (đợt sale này ko có deal 1đ tuy nhiên rất nhiều sản phẩm xịn sò giá cực rẻ nhé) </br></br>\r\nChọn sản phẩm xong thì bỏ vào giỏ hàng. </br></br>\r\nTiếp theo là hẹn giờ săn deal. Nên đặt chuông báo thức trước giờ mở bán 3-5 phút để bạn kịp chuẩn bị. </br></br>\r\n– Ngoài trang flash sale Lazada thì hàng ngày groups Hội Săn Deal vẫn luôn đăng tải các deal hot nhất, đáng mua nhất. Trước khung giờ mở bán deal 1đ thì các admin cũng đăng tải đầy đủ. Bạn có thể vào groups Hội Săn Deal và tương tác thường xuyên để ko bị bỏ lỡ các thông tin hót hòn họt nhé (nếu bạn ít tương tác thì sẽ ít thấy tin từ groups, biết đâu khi thấy tin hot thì lại qua mất khung giờ săn sale rồi)\r\n', 5, 1, 'https://hoc11.vn/wp-content/uploads/2020/12/1BIKIP.jpg'),
(2, '2021-06-06', '<b>Hướng dẫn chọn size giày và bảng quy đổi size giày</b>', 'Bạn muốn mua một đôi giày nhưng lại không biết cách đo size giày sao cho chuẩn? Hãy cùng Vina giày tìm hiểu các bước đo zise giày và bảng quy chuẩn size giày theo Việt Nam, US và UK dưới đây nhé', '<h3>Bước 1: Để bàn chân lên một mặt phẳng sáng màu rồi dùng thước dây cùng 1 chiếc thước kẻ để đo chiều dài, chiều rộng của bàn chân:</h3>\r\n\r\n+ Chiều dài: Đo từ ngón chân dài nhất đến gót giày.\r\n+ Chiều rộng: Dùng thước dây để đo một vòng bàn chân. </br></br>\r\n\r\n<h3>Bước 2: Ghi lại số đo chính xác gồm chiều dài, chiều rộng của bàn chân<h3>\r\n</br>\r\n\r\n<h3>Bước 3: Dùng số đo đó để đối chiếu với kích thước trong bảng size giày của Vina-Giầy để chọn đôi giày có size phù hợp.</h3>\r\n\r\nLưu ý:  - Thời gian tốt nhất để bạn đo cỡ giày của mình là vào lúc cuối ngày, khi đôi chân của bạn đã hoàn toàn được thư giãn. - Nếu có sai số giữa hai bàn chân, bạn hãy chọn đôi giày có cỡ bằng với chân lớn hơn của bạn. - Việc chọn đúng size là cực kỳ quan trọng. Một đôi giày phù hợp là một đôi giày ôm chân, không kích đầu mũi. Có thể để thừa đầu 0,5 cm.</br>\r\n</br>\r\n<i>Hãy chọn đúng size giày của mình để có thể trải nghiệm cảm giác tự tin thoải mái nhất với đôi giày mà mình yêu thích bạn nhé.</i>\r\n', 1, 2, 'https://anhdulichdep.com/wp-content/uploads/2019/01/chon-size-giay-1.jpg'),
(3, '2021-06-01', '<b>Cập Nhật Ngay Top 2 Xu Hướng Giày Sneaker 2021</b>', 'Bạn là có niềm yêu thích đối với sneaker? Bạn muốn cập nhật nhanh chóng xu hướng giày sneaker 2021 để đón đầu xu thế? Nhưng làm cách nào để cập nhật nhanh chóng thông tin khi có quá nhiều mẫu mã khác nhau trên thị trường. Đừng lo đã có OnlineShop giúp bạn giải quyết nổi lo rồi…', '<h3>1. Yeezy 350 V2 Static – Xu Hướng Giày Sneaker 2021</h3></br>\r\nGiày Yeezy 350 V2 Static là mẫu giày hot nhất hiện nay. Đúng chất xu hướng giày sneaker 2021 mà bạn đang tìm kiếm. Đôi giày này có khả năng phản quang toàn bộ, khi đi trong bóng tối sẽ khiến bạn trở nên nổi bật hơn. Với thiết kế năng động, cá tính đây là lựa chọn hoàn hảo cho những bạn muốn theo đuổi cá tính nổi bật. Chất liệu giày vô cùng cao cấp, phần vải thoáng khí và công nghệ boost nén. Giúp bạn cảm thấy thoải mái khi sử dụng đôi giày. Form chuẩn sneaker cho bạn tự tin khoe cá tính. </br></br></br>\r\n<h3>2. Nike M2k Tekno – Xu Hướng Giày Sneaker 2021 Thu Hút</h3></br>\r\nMẫu giày Nike M2k Tekno này có thể phù hợp cho cả nam và nữ. Bởi thiết kế thời thượng và hiện đại. Với kiểu dáng thể thao giúp ôm sát đôi chân. Phần upper được làm bằng da cao cấp mịn mang đến cảm giác mềm mại. Lớp đệm Phylon siêu nhẹ giúp đôi chân dễ chịu suốt cả ngày. Công nghệ cố định gót chân TPU giúp bảo vệ đôi chân. Đế ngoài bằng cao su chống trượt tạo cảm giác linh hoạt khi di chuyển. Với kiểu dáng hiện đại và thời trang cùng với chất liệu cao cấp. Thật không khó hiểu khi đôi giày sneaker này lại được yêu thích đến vậy.\r\n', 4, 1, 'https://product.hstatic.net/1000243581/product/upload_6c157bb8acaa44db90d13b4bbaf9c09b_1024x1024.jpg'),
(6, '2020-02-03', '<b>Nên chọn hình thức vận chuyển nào?</b>', 'Hình thức vận chuyển, giao hàng TheWay rất đa dạng. Đơn vị vận chuyển nào cũng có các ưu, nhược điểm khác nhau. Vậy cụ thể các hình thức giao hàng của TheWay ra sao? Những lưu ý gì khi nhận được hàng? Câu trả lời sẽ được giải đáp trong bài viết này.', '<h3>Dịch vụ giao hàng TheWay Giao Hàng Nhanh</h3>\r\n\r\nGiao hàng nhanh là đơn vị vận chuyển trong nước có thế mạnh về khoản giao hàng thu tiền hộ. Được thành lập từ năm 2012 đến nay, đơn vị này đã giành được đông đảo các chủ shop sử dụng. \r\n</br>\r\nGiá vận chuyển của Giao hàng nhanh dao động từ 20.000 - 85.000vnđ.\r\n</br>\r\n•	Website: https://giaohangnhanh.vn\r\n</br>\r\n•	Số điện thoại: 1800 12 01\r\n</br></br>\r\n\r\n\r\n<h2><i>Ưu điểm:</i></h2>\r\n•	Độ phủ sóng rộng khắp 63 tỉnh thành Việt Nam, chỉ đứng sau Viettel Post và VNPost\r\n</br>\r\n•	Giá cả phải chẳng\r\n</br>\r\n•	Miễn phí thu hộ\r\n</br>\r\n\r\n•	Quy trình giải quyết thắc mắc, khiếu nại của tổng đài hỗ trợ khách hàng rất tốt\r\n</br>\r\n\r\n•	Có chế độ bồi thường thiệt hại trong trường hợp hàng hóa bị hư hỏng.\r\n</br></br>\r\n\r\n\r\n<h2><i>Nhược điểm: </h2></i>\r\n•	Thời gian giao hàng ở mức trung bình\r\n</br>\r\n•	Phí COD cao hơn hẳn so với các đơn vị vận chuyển khác\r\n</br>\r\n•	Quy trình bảo quản và đóng gói hàng còn gặp nhiều sai sót\r\n</br>\r\n•	Thời gian chuyển trả tiền COD lâu\r\n</br>\r\n', 1, 1, 'https://cdn.chanhtuoi.com/uploads/2020/08/w400/giao-hang-shopee-01.png.webp');

-- --------------------------------------------------------

--
-- Table structure for table `blog_categories`
--

CREATE TABLE `blog_categories` (
  `blog_id` int(11) NOT NULL,
  `blog_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blog_categories`
--

INSERT INTO `blog_categories` (`blog_id`, `blog_name`) VALUES
(1, 'news '),
(2, 'event');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `user_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `full_name` varchar(60) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `User_Account_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`user_id`, `status`, `full_name`, `phone`, `email`, `address`, `User_Account_user_id`) VALUES
(1, '', 'Nguyen Phuong Nam ', 983917172, 'namnp@gmail.com', 'Hà Nội', 1),
(2, '', 'Vu Tien Dat', 482723718, 'datvt@gmail.com', 'hn', 2),
(3, '', 'Le Bao Long', 893516723, 'longlbhe140604@fpt.edu.vn', 'sl', 3),
(4, '', 'Nguyen Xuan Hai', 452146214, 'hainx@gmail.com', 'hn', 4);

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

CREATE TABLE `cart_item` (
  `item_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `url` varchar(1000) NOT NULL,
  `unit_price` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `Cart_user_id` int(11) NOT NULL,
  `Products_product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart_item`
--

INSERT INTO `cart_item` (`item_id`, `product_id`, `product_name`, `url`, `unit_price`, `quantity`, `Cart_user_id`, `Products_product_id`) VALUES
(1, 4, 'SlipOn', 'images/4.jpg', 1750000, 1, 1, 4),
(2, 15, 'Wmns Air Jordan 1', 'images/15.jpg', 5900000, 1, 2, 15),
(3, 7, 'Air Max 1', 'images/7.jpg', 2750000, 1, 3, 7),
(4, 6, 'Gel-Lyte', 'images/6.jpg', 1550000, 1, 4, 6);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `note` varchar(1000) NOT NULL,
  `status` int(1) NOT NULL,
  `User_Account_user_id` int(11) NOT NULL,
  `products_product_id` int(11) NOT NULL,
  `star_rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `description`, `note`, `status`, `User_Account_user_id`, `products_product_id`, `star_rating`) VALUES
(1, 'San pham chat luong, giao hang nhanh. Se tiep tuc ung ho', 'Done!', 1, 1, 13, 5),
(2, 'Thieu day giay', 'Gui them day giay cho khach', 0, 2, 6, 1),
(3, 'Giay dep lam shop oi', 'Done!', 1, 13, 3, 4),
(4, 'Giay dep qua', 'Done!', 1, 4, 14, 4),
(5, 'Giay dep nhung giao hang khong dung thoi gian!!!', 'Gui lai phan hoi cho Giao hang tiet kiem', 0, 3, 5, 2),
(6, 'Giay di em, chay nhay tot', 'Done!', 1, 5, 4, 5),
(7, 'Chua di doi giay nao dep nhu nay', 'Done!', 1, 13, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `img_id` int(100) NOT NULL,
  `product_id` int(100) NOT NULL,
  `url` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `oder_details`
--

CREATE TABLE `oder_details` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `unit_price` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `Order_order_id` int(11) NOT NULL,
  `Products_product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oder_details`
--

INSERT INTO `oder_details` (`order_id`, `product_id`, `unit_price`, `quantity`, `Order_order_id`, `Products_product_id`) VALUES
(1, 4, 1750000, 1, 1, 4),
(2, 15, 5900000, 1, 2, 15),
(3, 7, 2750000, 1, 3, 7),
(4, 6, 1550000, 1, 4, 6);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `name_receiver` varchar(60) NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(60) NOT NULL,
  `address` varchar(100) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `shipped_date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `User_Account_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`order_id`, `customer_id`, `name_receiver`, `phone`, `email`, `address`, `employee_id`, `order_date`, `shipped_date`, `status`, `note`, `User_Account_user_id`) VALUES
(1, 1, 'Nguyen Phuong Nam ', 983917172, 'namnp@gmail.com', 'hn', 10, '2021-06-09', '2021-06-15', 'shipping', NULL, 1),
(2, 2, 'Vu Tien Dat', 482723718, 'datvt@gmail.com', 'hn', 6, '2021-06-05', '2021-06-11', 'shipping', NULL, 2),
(3, 3, 'Le Bao Long', 893516723, 'longlbhe140604@fpt.edu.vn', 'sl', 7, '2021-06-11', '2021-06-17', 'shipping', NULL, 3),
(4, 4, 'Nguyen Xuan Hai', 452146214, 'hainx@gmail.com', 'hn', 6, '2021-06-09', '2021-06-15', 'shipping', NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `brief_information` varchar(200) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `create_date` date DEFAULT NULL,
  `image` varchar(200) NOT NULL,
  `User_Account_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `content`, `brief_information`, `description`, `create_date`, `image`, `User_Account_user_id`) VALUES
(1, '2021 fall-winter men\'s shoe trends', 'Trends From the Men’s Fall 2021 Shows', 'Choosing the right shoes for cold weather has always been a serious decision for men. It is more difficult for men than women of fashion to choose a high-quality boots or booties that will not only warm their feet, but will also be trendy. Below we will introduce you men’s shoes trends of 2019-2020.\r\nFashion trends\r\nSuede shoes for men are on top of the 2019-2020 shoe styles, although they are not considered as the most practical ones. This fancy material requires very delicate care; however, it always looks stylish and expensive. The most fashionable shades of suede will be considered gray, green, blue and metallic.', '2021-06-02', 'images/blog2.jpg', 3),
(2, 'A shoe lover', 'A shoe lover', 'and a great painter,  Pavlos Samios passed away.\r\n\r\nYesterday, the artist Pavlos Samios,  a great painter and a university professor at the School of Fine Arts, passed away at the age of 73.\r\n\r\nSamios was born on October 1948 in  Athens.\r\nHe started painting and drawing by helping his father with his shoe workshop when he used to spend many hours.\r\nHe designed the shoes so well that his father sent him to copy designs from the branded shop windows of the time.\r\nThe famous painter did not forget his passion. A pair of red heeled pumps were usually the touch he so much wanted to add to almost all of his paintings.\r\n\r\nPavlos Samios struggled with the optimism that characterised him until the last hour.\r\nWith his painting and the messages he spread in it, he is one winner of life.', '2021-05-12', 'images/blog1.jpg', 1),
(3, 'Everything you need to know to break in, size & lace Dr. Martens', 'The history of Dr. Martens', 'We are all about a Dr. Martens boot, and this iconic British shoe brand is loved by many. Bursting onto the British streets in the ’60s, Docs captured the attention of everyone from police officers to punk rockers with their distinctive style, robust construction and characteristic features. Distinguished by air-cushioned soles (dubbed Bouncing Soles), a welted construction and vivid yellow stitching. Dr. Martens not only produce its famous boots, but has dipped their toe into other product waters too (their handbags are also one of our favourites).', '2021-05-13', 'images/blog3.jpg', 2),
(4, 'SECOND HAND SHOPPING ROUND UP', 'SECOND HAND SHOPPING ROUND UP', 'Happy New Year everybody! I hope you all had a pleasant and non-transmissive New Years Eve. I got the house clean, watched a comedy show via Zoom with my friends, went crazy setting up my new 2021 Hobonichi planner, and drank champagne. It was a lovely way to ring in the new year but I couldn’t shake the feeling that something was missing from my life. After assessing my needs, basic and spiritual, I realized that the hole I felt in my heart was from a lack of thrifting, a lack of consignment store haunting, a lack of vintage! I really don’t feel comfortable spending long stretches of time in any store now, period, no matter how much I miss shopping. I so badly miss spending hours chatting and trying things on at Vintage Martini with the owner and my friend Ken Weber. I miss hitting Crossroads Trading weekly, and finding things like the $35 Comme Des Garcons anime dress. I miss coming home from an antique mall with an armful of tasteless novelty cocktail coups that I know will horrify ', '2021-05-20', 'images/blog4.jpg', 4);

-- --------------------------------------------------------

--
-- Table structure for table `post_categories`
--

CREATE TABLE `post_categories` (
  `post_id` int(11) NOT NULL,
  `post_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post_categories`
--

INSERT INTO `post_categories` (`post_id`, `post_name`) VALUES
(1, 'news'),
(2, 'even');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `unit_price` float NOT NULL,
  `sale_price` float NOT NULL,
  `unitsln_stock` int(11) DEFAULT NULL,
  `discontinued` tinyint(4) DEFAULT NULL,
  `brief_information` varchar(200) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `description-short` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `category_id`, `unit_price`, `sale_price`, `unitsln_stock`, `discontinued`, `brief_information`, `description`, `url`, `description-short`) VALUES
(2, 'Chuck Taylor', 2, 2350000, 2110000, 25, NULL, ' Chuck Taylor 1970s Low', 'Converse Chuck Taylor All Star 1970s Low Top Black shoes are designed from lightweight canvas material, thick, stiffer form. The iconic and iconic Converse shoe line. Thick lining creates a smooth feeling when moving, thick fabric, stiffer form. The vintage ivory white sole is covered with a glossy outer layer that is a unique highlight for the 1970s line, easier to clean.', 'images/2.jpg', ''),
(3, 'Air Force 1', 2, 2650000, 2385000, 65, NULL, 'Nike Air Force 1', 'Designed by Bruce Kilgore and introduced in 1982, the AF1 was the first basketball shoe to feature Nike Air Technologyârevolutionizing the game and sneaker', 'images/3.jpg', ''),
(4, 'SlipOn', 1, 1750000, 1575000, 82, NULL, 'Vans Slip On cer', 'Vans Classic Slip-On shoes. The Canvas Classic Slip-on has a low profile, slip-on canvas upper with elastic side accents, Vans flag label and Vans original Waffle Outsole. Imported.', 'images/4.jpg', ''),
(5, 'Blazer\r\n', 2, 3200000, 2880000, 14, NULL, 'Nike blazer mid 77', 'Leather and synthetic upper gives comfortable support. Vintage treatment on the midsole provides an old-school look. Autoclave construction fuses the outsole to the midsole for a streamlined look. Exposed foam on the tongue provides a throwback look. Non-marking, solid-rubber outsole has a herringbone pattern for excellent traction and durability.', 'images/5.jpg', ''),
(6, 'Gel-Lyte', 6, 1550000, 1395000, 61, NULL, 'Gel-Lyte III', 'ASICS GEL-Lyte III uppers consist of the finest mesh, nylon and synthetic suede without sacrificing any of their traditional lightweight characteristics and breathability.', 'images/6.jpg', ''),
(7, 'Air Max 1', 2, 2750000, 2475000, 34, NULL, 'Nike Air Max 1', 'Originally releasing in 1987, this Tinker Hatfield design was well ahead of its contemporaries when it first released. The midsole boasts that famed visible Air Unit that had never been seen before. 30 plus years on, this sneaker is still every bit as comfortable. The outsole shows off a retro look that remains popular with sneakerheads even today.', 'images/7.jpg', ''),
(8, 'Jordan 1', 5, 3000000, 2700000, 5, NULL, 'Jordan 1 Low \'Reverse Bred\'', 'The Jordan 1 Low Reverse Bred has the same legendary durability and functionality features of Michael Jordan\'s first signature sneaker but with a low-cut', 'images/8.jpg', ''),
(9, 'Air Jordan 1', 5, 3900000, 3510000, 7, NULL, 'Air Jordan 1 Mid ‘Hyper Royal’', 'Featuring a look that\'s almost identical to 1985\'s Air Jordan 1 \'Royal,\' the Air Jordan 1 Mid \'Hyper Royal\' released in February 2021.', 'images/9.jpg', ''),
(10, 'Jordan 4', 5, 7900000, 7100000, 69, NULL, 'Jordan 4 Retro University Blue', 'Details Details The Air Jordan 4 “UNC” is an April 2021 colorway of Michael Jordan’s fourth signature shoe that honors Michael’s alma mater, the University of North Carolina. The first-ever Jordan 4 in a “UNC” makeup, this collegiate design follows previous Air Jordans to employ the popular theme—the Air Jordan 3 “UNC” and the Women’s Air Jordan 1 Mid “UNC” from 2020.', 'images/10.jpg', ''),
(11, 'Pureboost', 6, 2150000, 1935000, 41, NULL, 'Pureboost Trainer', 'Feel connected to the ground under your feet. The Pureboost running shoes are engineered with an adaptive, criss-cross upper and a protective collar for a perfect fit. Pair that with boost cushioning that returns energy to your stride, and an all-terrain ATR outsole that provides optimal traction on wet or slippery surfaces.', 'images/11.jpg', ''),
(12, 'Continental', 6, 1290000, 1160000, 12, NULL, 'Continental 80', 'The Adidas Continental 80 is found in men\'s and women\'s sizes. It has a leather upper that offers the wearer a stable fit, while also delivering a durable structure that\'s meant to last. Meanwhile, the sneaker has a low-cut design that allows generous ankle movement and does not hinder it.', 'images/12.jpg', ''),
(13, 'PUMA RS-X3', 4, 3250000, 2925000, 43, NULL, 'PUMA RS-X3 HARD DRIVE MENS', '\r\nPUMA RS-X3 HARD DRIVE MENS BLACK / RED / WHITE TRA...\r\n', 'images/13.jpg', ''),
(14, 'NMD_R1 V2', 3, 1700000, 1530000, 19, NULL, 'ADIDAS NMD_R1 V2', 'Embrace the future and move forward with confidence and grace. These adidas NMD_R1 V2 shoes are the next generation of the line that goes with your ambitions. Like the original design, the body of the shoe is made from a soft woven fabric that hugs your foot for the ultimate stride. The cushioned outsole returns energy with every stride. Bold and fresh colors. So that you always have the courage to go forward.', 'images/14.jpg', ''),
(15, 'Wmns Air Jordan 1', 5, 5900000, 5300000, 20, NULL, 'Nike Wmns Air Jordan 1 Low \'Chicago Flip\'', 'Embrace the future and move forward with confidence and grace. These adidas NMD_R1 V2 shoes are the next generation of the line that goes with your ambitions. Like the original design, the body of the shoe is made from a soft woven fabric that hugs your foot for the ultimate stride. The cushioned outsole returns energy with every stride. Bold and fresh colors. So that you always have the courage to go forward.', 'images/15.jpg', '');

-- --------------------------------------------------------

--
-- Table structure for table `product_categories`
--

CREATE TABLE `product_categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_categories`
--

INSERT INTO `product_categories` (`category_id`, `category_name`, `description`) VALUES
(1, 'Vanz', NULL),
(2, 'Nike', NULL),
(3, 'Adidas', NULL),
(4, 'Puma', NULL),
(5, 'Jordan', NULL),
(6, 'Other', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `slide`
--

CREATE TABLE `slide` (
  `slide_id` int(6) UNSIGNED NOT NULL,
  `img` varchar(255) NOT NULL,
  `heading` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name_button` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slide`
--

INSERT INTO `slide` (`slide_id`, `img`, `heading`, `description`, `name_button`, `url`, `status`) VALUES
(1, 'https://cdn.dribbble.com/users/2317528/screenshots/5332010/nike-adidas_shoe_slider.png', '3 Mẫu giày hot nhất', '<i>Đây là những mẫu bán chạy của shop,</br>\r\n Chiều chuộng những khách hàng khó tính nhất</i>\r\n', 'Click me!', 'ProductController', 1),
(2, 'https://3.bp.blogspot.com/-6NzsUIoOjaQ/Xgivt1hEluI/AAAAAAAAAMg/9wF7Hsm_mUc4NSOFax3vAN4lVKtQ8ka0gCLcBGAsYHQ/s1600/giay.png', 'HunterX', '<i>Tiếp bước hành trình Việt đi khắp 5 châu</i>', 'GO GO', 'ProductController', 1),
(3, 'https://theme.hstatic.net/200000238513/1000665981/14/slider_1.jpg?v=23', 'Cải thiện tốc độ', '<i>Cải thiện tốc độ vượt mọi rào cản</i>', 'Go to shop', 'ProductController', 1);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'Active'),
(2, 'Waiting'),
(3, 'Ban');

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

CREATE TABLE `user_account` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(60) NOT NULL,
  `password` varchar(32) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `middle_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`user_id`, `user_name`, `password`, `first_name`, `middle_name`, `last_name`, `gender`, `phone`, `email`, `status_id`, `authority_id`, `code`) VALUES
(1, 'namnp', '123456', 'Nguyen', 'Phuong', 'Nam ', 0, '983917172', 'namnp@gmail.com', 1, 1, ''),
(2, 'datvt', '123456', 'Vu', 'Tien', 'Dat', 1, '482723718', 'datvt@gmail.com', 1, 2, ''),
(3, 'longlb', '123456', 'Le', 'Bao', 'Long', 1, '893516723', 'longlb@gmail.com', 1, 2, ''),
(4, 'hainx', '123456', 'Nguyen', 'Xuan', 'Hai', 1, '452146214', 'hainx@gmail.com', 1, 3, ''),
(5, 'vutiendatfa', '123456', 'Vu', 'Tien', 'Dat', 0, '765783586', 'vutiendatdino@gmail.com', 1, 3, ''),
(13, 'vutiendatfb', '123456', 'Vu', 'Tien', 'Dat1', 0, '339006115', 'vutiendatdino@gmail.com', 1, 3, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`blog_id`),
  ADD KEY `category_blog_id` (`category_blog_id`),
  ADD KEY `fk_Blog_User_Account1` (`User_Account_user_id`);

--
-- Indexes for table `blog_categories`
--
ALTER TABLE `blog_categories`
  ADD PRIMARY KEY (`blog_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `fk_Cart_User_Account_idx` (`User_Account_user_id`);

--
-- Indexes for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `fk_Category_Item_Cart1_idx` (`Cart_user_id`),
  ADD KEY `fk_Category_Item_Products1_idx` (`Products_product_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `fk_FeedBack_User_Account1_idx` (`User_Account_user_id`),
  ADD KEY `fk_feedback_products1_idx` (`products_product_id`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`img_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `oder_details`
--
ALTER TABLE `oder_details`
  ADD PRIMARY KEY (`order_id`,`product_id`),
  ADD KEY `fk_Oder_details_Order1_idx` (`Order_order_id`),
  ADD KEY `fk_Oder_details_Products1_idx` (`Products_product_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `fk_Order_User_Account1_idx` (`User_Account_user_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `fk_Post_User_Account1_idx` (`User_Account_user_id`);

--
-- Indexes for table `post_categories`
--
ALTER TABLE `post_categories`
  ADD PRIMARY KEY (`post_id`),
  ADD UNIQUE KEY `post_id` (`post_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `product_categories`
--
ALTER TABLE `product_categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `slide`
--
ALTER TABLE `slide`
  ADD PRIMARY KEY (`slide_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `fk_User_Account_Authority1_idx` (`status_id`),
  ADD KEY `authority_id` (`authority_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authority`
--
ALTER TABLE `authority`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `blog_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `blog_categories`
--
ALTER TABLE `blog_categories`
  MODIFY `blog_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `cart_item`
--
ALTER TABLE `cart_item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `oder_details`
--
ALTER TABLE `oder_details`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `product_categories`
--
ALTER TABLE `product_categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `slide`
--
ALTER TABLE `slide`
  MODIFY `slide_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_account`
--
ALTER TABLE `user_account`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`category_blog_id`) REFERENCES `blog_categories` (`blog_id`),
  ADD CONSTRAINT `fk_Blog_User_Account1` FOREIGN KEY (`User_Account_user_id`) REFERENCES `user_account` (`user_id`);

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_Cart_User_Account` FOREIGN KEY (`User_Account_user_id`) REFERENCES `user_account` (`user_id`);

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `fk_Category_Item_Cart1` FOREIGN KEY (`Cart_user_id`) REFERENCES `cart` (`user_id`),
  ADD CONSTRAINT `fk_Category_Item_Products1` FOREIGN KEY (`Products_product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `fk_FeedBack_User_Account1` FOREIGN KEY (`User_Account_user_id`) REFERENCES `user_account` (`user_id`),
  ADD CONSTRAINT `fk_feedback_products1` FOREIGN KEY (`products_product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `oder_details`
--
ALTER TABLE `oder_details`
  ADD CONSTRAINT `fk_Oder_details_Order1` FOREIGN KEY (`Order_order_id`) REFERENCES `order` (`order_id`),
  ADD CONSTRAINT `fk_Oder_details_Products1` FOREIGN KEY (`Products_product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_Order_User_Account1` FOREIGN KEY (`User_Account_user_id`) REFERENCES `user_account` (`user_id`);

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `fk_Post_User_Account1` FOREIGN KEY (`User_Account_user_id`) REFERENCES `user_account` (`user_id`);

--
-- Constraints for table `post_categories`
--
ALTER TABLE `post_categories`
  ADD CONSTRAINT `post_categories_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `product_categories` (`category_id`);

--
-- Constraints for table `user_account`
--
ALTER TABLE `user_account`
  ADD CONSTRAINT `fk_User_Account_Authority1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
