-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 07, 2022 lúc 04:58 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shop8`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blogs`
--

CREATE TABLE `blogs` (
  `blog_id` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `noidung` longtext NOT NULL,
  `userID` int(11) NOT NULL,
  `blogCategoryID` int(11) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `blogs`
--

INSERT INTO `blogs` (`blog_id`, `create_date`, `content`, `description`, `noidung`, `userID`, `blogCategoryID`, `img`) VALUES
(1, '2021-06-10', '<b>Bí kíp săn deal 1đ, 1K</b>', 'Như mình có nói ở phần trước: “Săn sale là một nghệ thuật, người săn sale là một nghệ sĩ”. Để thành nghệ sĩ săn sale thực thụ thì bạn cần nắm vững các bước để săn sale. Sau đó bạn phải luyện tập thật nhiều để nhanh hơn 99% người còn lại và dành chiến thắng trong cuộc chiến săn sale này.', '<em><i>– Sản phẩm flash sale 1đ-1k… nói chung là sản phẩm giá rẻ, deal hủy diệt sẽ nằm ở trên trang flash sale của Lazada. Xem tại trang này ⇒<u> http://go.bgg.zone/LFvnrx</u></i></em></br></br>\r\nBạn mở các khung giờ sắp mở bán để chọn deal cần mua như hình. (đợt sale này ko có deal 1đ tuy nhiên rất nhiều sản phẩm xịn sò giá cực rẻ nhé) </br></br>\r\nChọn sản phẩm xong thì bỏ vào giỏ hàng. </br></br>\r\nTiếp theo là hẹn giờ săn deal. Nên đặt chuông báo thức trước giờ mở bán 3-5 phút để bạn kịp chuẩn bị. </br></br>\r\n– Ngoài trang flash sale Lazada thì hàng ngày groups Hội Săn Deal vẫn luôn đăng tải các deal hot nhất, đáng mua nhất. Trước khung giờ mở bán deal 1đ thì các admin cũng đăng tải đầy đủ. Bạn có thể vào groups Hội Săn Deal và tương tác thường xuyên để ko bị bỏ lỡ các thông tin hót hòn họt nhé (nếu bạn ít tương tác thì sẽ ít thấy tin từ groups, biết đâu khi thấy tin hot thì lại qua mất khung giờ săn sale rồi)\r\n', 5, 1, 'https://hoc11.vn/wp-content/uploads/2020/12/1BIKIP.jpg'),
(2, '2021-06-06', '<b>Hướng dẫn chọn size giày và bảng quy đổi size giày</b>', 'Bạn muốn mua một đôi giày nhưng lại không biết cách đo size giày sao cho chuẩn? Hãy cùng Vina giày tìm hiểu các bước đo zise giày và bảng quy chuẩn size giày theo Việt Nam, US và UK dưới đây nhé', '<h3>Bước 1: Để bàn chân lên một mặt phẳng sáng màu rồi dùng thước dây cùng 1 chiếc thước kẻ để đo chiều dài, chiều rộng của bàn chân:</h3>\r\n\r\n+ Chiều dài: Đo từ ngón chân dài nhất đến gót giày.\r\n+ Chiều rộng: Dùng thước dây để đo một vòng bàn chân. </br></br>\r\n\r\n<h3>Bước 2: Ghi lại số đo chính xác gồm chiều dài, chiều rộng của bàn chân<h3>\r\n</br>\r\n\r\n<h3>Bước 3: Dùng số đo đó để đối chiếu với kích thước trong bảng size giày của Vina-Giầy để chọn đôi giày có size phù hợp.</h3>\r\n\r\nLưu ý:  - Thời gian tốt nhất để bạn đo cỡ giày của mình là vào lúc cuối ngày, khi đôi chân của bạn đã hoàn toàn được thư giãn. - Nếu có sai số giữa hai bàn chân, bạn hãy chọn đôi giày có cỡ bằng với chân lớn hơn của bạn. - Việc chọn đúng size là cực kỳ quan trọng. Một đôi giày phù hợp là một đôi giày ôm chân, không kích đầu mũi. Có thể để thừa đầu 0,5 cm.</br>\r\n</br>\r\n<i>Hãy chọn đúng size giày của mình để có thể trải nghiệm cảm giác tự tin thoải mái nhất với đôi giày mà mình yêu thích bạn nhé.</i>\r\n', 1, 2, 'https://anhdulichdep.com/wp-content/uploads/2019/01/chon-size-giay-1.jpg'),
(3, '2021-06-01', '<b>Cập Nhật Ngay Top 2 Xu Hướng Giày Sneaker 2021</b>', 'Bạn là có niềm yêu thích đối với sneaker? Bạn muốn cập nhật nhanh chóng xu hướng giày sneaker 2021 để đón đầu xu thế? Nhưng làm cách nào để cập nhật nhanh chóng thông tin khi có quá nhiều mẫu mã khác nhau trên thị trường. Đừng lo đã có OnlineShop giúp bạn giải quyết nổi lo rồi…', '<h3>1. Yeezy 350 V2 Static – Xu Hướng Giày Sneaker 2021</h3></br>\r\nGiày Yeezy 350 V2 Static là mẫu giày hot nhất hiện nay. Đúng chất xu hướng giày sneaker 2021 mà bạn đang tìm kiếm. Đôi giày này có khả năng phản quang toàn bộ, khi đi trong bóng tối sẽ khiến bạn trở nên nổi bật hơn. Với thiết kế năng động, cá tính đây là lựa chọn hoàn hảo cho những bạn muốn theo đuổi cá tính nổi bật. Chất liệu giày vô cùng cao cấp, phần vải thoáng khí và công nghệ boost nén. Giúp bạn cảm thấy thoải mái khi sử dụng đôi giày. Form chuẩn sneaker cho bạn tự tin khoe cá tính. </br></br></br>\r\n<h3>2. Nike M2k Tekno – Xu Hướng Giày Sneaker 2021 Thu Hút</h3></br>\r\nMẫu giày Nike M2k Tekno này có thể phù hợp cho cả nam và nữ. Bởi thiết kế thời thượng và hiện đại. Với kiểu dáng thể thao giúp ôm sát đôi chân. Phần upper được làm bằng da cao cấp mịn mang đến cảm giác mềm mại. Lớp đệm Phylon siêu nhẹ giúp đôi chân dễ chịu suốt cả ngày. Công nghệ cố định gót chân TPU giúp bảo vệ đôi chân. Đế ngoài bằng cao su chống trượt tạo cảm giác linh hoạt khi di chuyển. Với kiểu dáng hiện đại và thời trang cùng với chất liệu cao cấp. Thật không khó hiểu khi đôi giày sneaker này lại được yêu thích đến vậy.\r\n', 4, 1, 'https://product.hstatic.net/1000243581/product/upload_6c157bb8acaa44db90d13b4bbaf9c09b_1024x1024.jpg'),
(6, '2020-02-03', '<b>Nên chọn hình thức vận chuyển nào?</b>', 'Hình thức vận chuyển, giao hàng TheWay rất đa dạng. Đơn vị vận chuyển nào cũng có các ưu, nhược điểm khác nhau. Vậy cụ thể các hình thức giao hàng của TheWay ra sao? Những lưu ý gì khi nhận được hàng? Câu trả lời sẽ được giải đáp trong bài viết này.', '<h3>Dịch vụ giao hàng TheWay Giao Hàng Nhanh</h3>\r\n\r\nGiao hàng nhanh là đơn vị vận chuyển trong nước có thế mạnh về khoản giao hàng thu tiền hộ. Được thành lập từ năm 2012 đến nay, đơn vị này đã giành được đông đảo các chủ shop sử dụng. \r\n</br>\r\nGiá vận chuyển của Giao hàng nhanh dao động từ 20.000 - 85.000vnđ.\r\n</br>\r\n•	Website: https://giaohangnhanh.vn\r\n</br>\r\n•	Số điện thoại: 1800 12 01\r\n</br></br>\r\n\r\n\r\n<h2><i>Ưu điểm:</i></h2>\r\n•	Độ phủ sóng rộng khắp 63 tỉnh thành Việt Nam, chỉ đứng sau Viettel Post và VNPost\r\n</br>\r\n•	Giá cả phải chẳng\r\n</br>\r\n•	Miễn phí thu hộ\r\n</br>\r\n\r\n•	Quy trình giải quyết thắc mắc, khiếu nại của tổng đài hỗ trợ khách hàng rất tốt\r\n</br>\r\n\r\n•	Có chế độ bồi thường thiệt hại trong trường hợp hàng hóa bị hư hỏng.\r\n</br></br>\r\n\r\n\r\n<h2><i>Nhược điểm: </h2></i>\r\n•	Thời gian giao hàng ở mức trung bình\r\n</br>\r\n•	Phí COD cao hơn hẳn so với các đơn vị vận chuyển khác\r\n</br>\r\n•	Quy trình bảo quản và đóng gói hàng còn gặp nhiều sai sót\r\n</br>\r\n•	Thời gian chuyển trả tiền COD lâu\r\n</br>\r\n', 1, 1, 'https://cdn.chanhtuoi.com/uploads/2020/08/w400/giao-hang-shopee-01.png.webp');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog_categories`
--

CREATE TABLE `blog_categories` (
  `blogCategoryID` int(11) NOT NULL,
  `blogCategoryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `blog_categories`
--

INSERT INTO `blog_categories` (`blogCategoryID`, `blogCategoryName`) VALUES
(1, 'news '),
(2, 'event');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `carts`
--

CREATE TABLE `carts` (
  `cartID` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createDate` date NOT NULL,
  `updateDate` date NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `carts`
--

INSERT INTO `carts` (`cartID`, `status`, `createDate`, `updateDate`, `userID`) VALUES
(1, NULL, '0000-00-00', '0000-00-00', 1),
(2, NULL, '0000-00-00', '0000-00-00', 2),
(3, NULL, '0000-00-00', '0000-00-00', 3),
(4, NULL, '0000-00-00', '0000-00-00', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart_items`
--

CREATE TABLE `cart_items` (
  `item_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cartID` int(11) NOT NULL,
  `productID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `cart_items`
--

INSERT INTO `cart_items` (`item_id`, `quantity`, `cartID`, `productID`) VALUES
(1, 1, 1, 4),
(2, 1, 2, 14),
(3, 1, 3, 7),
(4, 1, 4, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `countries`
--

CREATE TABLE `countries` (
  `countryID` int(11) NOT NULL,
  `countryName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `countries`
--

INSERT INTO `countries` (`countryID`, `countryName`) VALUES
(15, 'Việt Nam'),
(16, 'United States'),
(17, 'Germany'),
(18, 'China');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `districts`
--

CREATE TABLE `districts` (
  `districtID` int(11) NOT NULL,
  `districtName` varchar(50) NOT NULL,
  `provinceID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `districts`
--

INSERT INTO `districts` (`districtID`, `districtName`, `provinceID`) VALUES
(15, 'Ba Đình', NULL),
(16, 'Hoàn Kiếm', NULL),
(17, 'Hai Bà Trưng', NULL),
(18, 'Long Biên', NULL),
(19, 'Ý Yên', NULL),
(20, 'Đông Anh', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `electronicaddress`
--

CREATE TABLE `electronicaddress` (
  `eaID` int(11) NOT NULL,
  `webSite` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favorite_products`
--

CREATE TABLE `favorite_products` (
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feedbacks`
--

CREATE TABLE `feedbacks` (
  `feedback_id` int(11) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `note` varchar(1000) NOT NULL,
  `status` int(1) NOT NULL,
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `createDate` date NOT NULL,
  `updateDate` date DEFAULT NULL,
  `star_rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `feedbacks`
--

INSERT INTO `feedbacks` (`feedback_id`, `description`, `note`, `status`, `userID`, `productID`, `createDate`, `updateDate`, `star_rating`) VALUES
(1, 'San pham chat luong, giao hang nhanh. Se tiep tuc ung ho', 'Done!', 1, 1, 13, '0000-00-00', NULL, 5),
(2, 'Thieu day giay', 'Gui them day giay cho khach', 0, 2, 6, '0000-00-00', NULL, 1),
(3, 'Giay dep lam shop oi', 'Done!', 1, 13, 3, '0000-00-00', NULL, 4),
(4, 'Giay dep qua', 'Done!', 1, 4, 14, '0000-00-00', NULL, 4),
(5, 'Giay dep nhung giao hang khong dung thoi gian!!!', 'Gui lai phan hoi cho Giao hang tiet kiem', 0, 3, 5, '0000-00-00', NULL, 2),
(6, 'Giay di em, chay nhay tot', 'Done!', 1, 5, 4, '0000-00-00', NULL, 5),
(7, 'Chua di doi giay nao dep nhu nay', 'Done!', 1, 13, 2, '0000-00-00', NULL, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `images`
--

CREATE TABLE `images` (
  `img_id` int(11) NOT NULL,
  `product_id` int(100) NOT NULL,
  `url` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `messengers`
--

CREATE TABLE `messengers` (
  `messengerID` int(11) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `fromID` int(11) NOT NULL,
  `toID` int(11) NOT NULL,
  `sendTime` datetime NOT NULL,
  `receivedTime` date DEFAULT NULL,
  `isRead` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `oder_details`
--

CREATE TABLE `oder_details` (
  `order_detailID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `oder_details`
--

INSERT INTO `oder_details` (`order_detailID`, `quantity`, `orderID`, `productID`, `amount`) VALUES
(1, 1, 1, 4, NULL),
(2, 1, 2, 14, NULL),
(3, 1, 2, 7, NULL),
(4, 1, 1, 6, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_date` date DEFAULT NULL,
  `require_date` date NOT NULL,
  `shipped_date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `shipperID` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `customerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`order_id`, `order_date`, `require_date`, `shipped_date`, `status`, `note`, `shipperID`, `employee_id`, `customerID`) VALUES
(1, '2021-06-09', '2021-06-15', '2021-06-15', '', '', 1, 4, 2),
(2, '2021-06-05', '2021-06-11', '2021-06-11', '', '', 1, 4, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `permissions`
--

CREATE TABLE `permissions` (
  `permissionID` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `permissions`
--

INSERT INTO `permissions` (`permissionID`, `name`) VALUES
(1, 'read'),
(2, 'write'),
(3, 'execute');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `posts`
--

CREATE TABLE `posts` (
  `post_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `brief_information` varchar(200) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `create_date` date DEFAULT NULL,
  `image` varchar(200) NOT NULL,
  `userID` int(11) NOT NULL,
  `postCategoryID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `posts`
--

INSERT INTO `posts` (`post_id`, `content`, `brief_information`, `description`, `create_date`, `image`, `userID`, `postCategoryID`) VALUES
(1, '2021 fall-winter men\'s shoe trends', 'Trends From the Men’s Fall 2021 Shows', 'Choosing the right shoes for cold weather has always been a serious decision for men. It is more difficult for men than women of fashion to choose a high-quality boots or booties that will not only warm their feet, but will also be trendy. Below we will introduce you men’s shoes trends of 2019-2020.\r\nFashion trends\r\nSuede shoes for men are on top of the 2019-2020 shoe styles, although they are not considered as the most practical ones. This fancy material requires very delicate care; however, it always looks stylish and expensive. The most fashionable shades of suede will be considered gray, green, blue and metallic.', '2021-06-02', 'images/blog2.jpg', 3, 1),
(2, 'A shoe lover', 'A shoe lover', 'and a great painter,  Pavlos Samios passed away.\r\n\r\nYesterday, the artist Pavlos Samios,  a great painter and a university professor at the School of Fine Arts, passed away at the age of 73.\r\n\r\nSamios was born on October 1948 in  Athens.\r\nHe started painting and drawing by helping his father with his shoe workshop when he used to spend many hours.\r\nHe designed the shoes so well that his father sent him to copy designs from the branded shop windows of the time.\r\nThe famous painter did not forget his passion. A pair of red heeled pumps were usually the touch he so much wanted to add to almost all of his paintings.\r\n\r\nPavlos Samios struggled with the optimism that characterised him until the last hour.\r\nWith his painting and the messages he spread in it, he is one winner of life.', '2021-05-12', 'images/blog1.jpg', 1, 1),
(3, 'Everything you need to know to break in, size & lace Dr. Martens', 'The history of Dr. Martens', 'We are all about a Dr. Martens boot, and this iconic British shoe brand is loved by many. Bursting onto the British streets in the ’60s, Docs captured the attention of everyone from police officers to punk rockers with their distinctive style, robust construction and characteristic features. Distinguished by air-cushioned soles (dubbed Bouncing Soles), a welted construction and vivid yellow stitching. Dr. Martens not only produce its famous boots, but has dipped their toe into other product waters too (their handbags are also one of our favourites).', '2021-05-13', 'images/blog3.jpg', 2, 1),
(4, 'SECOND HAND SHOPPING ROUND UP', 'SECOND HAND SHOPPING ROUND UP', 'Happy New Year everybody! I hope you all had a pleasant and non-transmissive New Years Eve. I got the house clean, watched a comedy show via Zoom with my friends, went crazy setting up my new 2021 Hobonichi planner, and drank champagne. It was a lovely way to ring in the new year but I couldn’t shake the feeling that something was missing from my life. After assessing my needs, basic and spiritual, I realized that the hole I felt in my heart was from a lack of thrifting, a lack of consignment store haunting, a lack of vintage! I really don’t feel comfortable spending long stretches of time in any store now, period, no matter how much I miss shopping. I so badly miss spending hours chatting and trying things on at Vintage Martini with the owner and my friend Ken Weber. I miss hitting Crossroads Trading weekly, and finding things like the $35 Comme Des Garcons anime dress. I miss coming home from an antique mall with an armful of tasteless novelty cocktail coups that I know will horrify ', '2021-05-20', 'images/blog4.jpg', 4, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post_categories`
--

CREATE TABLE `post_categories` (
  `postCategoryID` int(11) NOT NULL,
  `postCategoryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `post_categories`
--

INSERT INTO `post_categories` (`postCategoryID`, `postCategoryName`) VALUES
(1, 'news'),
(2, 'even');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
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
  `description-short` varchar(1000) NOT NULL,
  `views` int(100) DEFAULT NULL,
  `quantityLike` int(100) DEFAULT NULL,
  `supplierID` int(11) NOT NULL,
  `colorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `category_id`, `unit_price`, `sale_price`, `unitsln_stock`, `discontinued`, `brief_information`, `description`, `url`, `description-short`, `views`, `quantityLike`, `supplierID`, `colorID`) VALUES
(1, 'Wmns Air Jordan 1', 5, 5900000, 5300000, 20, NULL, 'Nike Wmns Air Jordan 1 Low \'Chicago Flip\'', 'Embrace the future and move forward with confidence and grace. These adidas NMD_R1 V2 shoes are the next generation of the line that goes with your ambitions. Like the original design, the body of the shoe is made from a soft woven fabric that hugs your foot for the ultimate stride. The cushioned outsole returns energy with every stride. Bold and fresh colors. So that you always have the courage to go forward.', 'images/15.jpg', '', 0, NULL, 1, NULL),
(2, 'Chuck Taylor', 2, 2350000, 2110000, 25, NULL, ' Chuck Taylor 1970s Low', 'Converse Chuck Taylor All Star 1970s Low Top Black shoes are designed from lightweight canvas material, thick, stiffer form. The iconic and iconic Converse shoe line. Thick lining creates a smooth feeling when moving, thick fabric, stiffer form. The vintage ivory white sole is covered with a glossy outer layer that is a unique highlight for the 1970s line, easier to clean.', 'images/2.jpg', '', 0, NULL, 1, NULL),
(3, 'Air Force 1', 2, 2650000, 2385000, 65, NULL, 'Nike Air Force 1', 'Designed by Bruce Kilgore and introduced in 1982, the AF1 was the first basketball shoe to feature Nike Air Technologyârevolutionizing the game and sneaker', 'images/3.jpg', '', 0, NULL, 1, NULL),
(4, 'SlipOn', 1, 1750000, 1575000, 82, NULL, 'Vans Slip On cer', 'Vans Classic Slip-On shoes. The Canvas Classic Slip-on has a low profile, slip-on canvas upper with elastic side accents, Vans flag label and Vans original Waffle Outsole. Imported.', 'images/4.jpg', '', 0, NULL, 1, NULL),
(5, 'Blazer\r\n', 2, 3200000, 2880000, 14, NULL, 'Nike blazer mid 77', 'Leather and synthetic upper gives comfortable support. Vintage treatment on the midsole provides an old-school look. Autoclave construction fuses the outsole to the midsole for a streamlined look. Exposed foam on the tongue provides a throwback look. Non-marking, solid-rubber outsole has a herringbone pattern for excellent traction and durability.', 'images/5.jpg', '', 0, NULL, 1, NULL),
(6, 'Gel-Lyte', 6, 1550000, 1395000, 61, NULL, 'Gel-Lyte III', 'ASICS GEL-Lyte III uppers consist of the finest mesh, nylon and synthetic suede without sacrificing any of their traditional lightweight characteristics and breathability.', 'images/6.jpg', '', 0, NULL, 1, NULL),
(7, 'Air Max 1', 2, 2750000, 2475000, 34, NULL, 'Nike Air Max 1', 'Originally releasing in 1987, this Tinker Hatfield design was well ahead of its contemporaries when it first released. The midsole boasts that famed visible Air Unit that had never been seen before. 30 plus years on, this sneaker is still every bit as comfortable. The outsole shows off a retro look that remains popular with sneakerheads even today.', 'images/7.jpg', '', 0, NULL, 1, NULL),
(8, 'Jordan 1', 5, 3000000, 2700000, 5, NULL, 'Jordan 1 Low \'Reverse Bred\'', 'The Jordan 1 Low Reverse Bred has the same legendary durability and functionality features of Michael Jordan\'s first signature sneaker but with a low-cut', 'images/8.jpg', '', 0, NULL, 1, NULL),
(9, 'Air Jordan 1', 5, 3900000, 3510000, 7, NULL, 'Air Jordan 1 Mid ‘Hyper Royal’', 'Featuring a look that\'s almost identical to 1985\'s Air Jordan 1 \'Royal,\' the Air Jordan 1 Mid \'Hyper Royal\' released in February 2021.', 'images/9.jpg', '', 0, NULL, 1, NULL),
(10, 'Jordan 4', 5, 7900000, 7100000, 69, NULL, 'Jordan 4 Retro University Blue', 'Details Details The Air Jordan 4 “UNC” is an April 2021 colorway of Michael Jordan’s fourth signature shoe that honors Michael’s alma mater, the University of North Carolina. The first-ever Jordan 4 in a “UNC” makeup, this collegiate design follows previous Air Jordans to employ the popular theme—the Air Jordan 3 “UNC” and the Women’s Air Jordan 1 Mid “UNC” from 2020.', 'images/10.jpg', '', 0, NULL, 1, NULL),
(11, 'Pureboost', 6, 2150000, 1935000, 41, NULL, 'Pureboost Trainer', 'Feel connected to the ground under your feet. The Pureboost running shoes are engineered with an adaptive, criss-cross upper and a protective collar for a perfect fit. Pair that with boost cushioning that returns energy to your stride, and an all-terrain ATR outsole that provides optimal traction on wet or slippery surfaces.', 'images/11.jpg', '', 0, NULL, 1, NULL),
(12, 'Continental', 6, 1290000, 1160000, 12, NULL, 'Continental 80', 'The Adidas Continental 80 is found in men\'s and women\'s sizes. It has a leather upper that offers the wearer a stable fit, while also delivering a durable structure that\'s meant to last. Meanwhile, the sneaker has a low-cut design that allows generous ankle movement and does not hinder it.', 'images/12.jpg', '', 0, NULL, 1, NULL),
(13, 'PUMA RS-X3', 4, 3250000, 2925000, 43, NULL, 'PUMA RS-X3 HARD DRIVE MENS', '\r\nPUMA RS-X3 HARD DRIVE MENS BLACK / RED / WHITE TRA...\r\n', 'images/13.jpg', '', 0, NULL, 1, NULL),
(14, 'NMD_R1 V2', 3, 1700000, 1530000, 19, NULL, 'ADIDAS NMD_R1 V2', 'Embrace the future and move forward with confidence and grace. These adidas NMD_R1 V2 shoes are the next generation of the line that goes with your ambitions. Like the original design, the body of the shoe is made from a soft woven fabric that hugs your foot for the ultimate stride. The cushioned outsole returns energy with every stride. Bold and fresh colors. So that you always have the courage to go forward.', 'images/14.jpg', '', 0, NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_categories`
--

CREATE TABLE `product_categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product_categories`
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
-- Cấu trúc bảng cho bảng `product_color`
--

CREATE TABLE `product_color` (
  `colorID` int(11) NOT NULL,
  `colorName` varchar(50) NOT NULL,
  `plusPrice` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `provinces`
--

CREATE TABLE `provinces` (
  `provinceID` int(11) NOT NULL,
  `provinceName` varchar(50) NOT NULL,
  `countryID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `provinces`
--

INSERT INTO `provinces` (`provinceID`, `provinceName`, `countryID`) VALUES
(15, 'Nam Định', NULL),
(16, 'Hải Phòng', NULL),
(17, 'Quảng Ninh', NULL),
(18, 'Hưng Yên', NULL),
(19, 'Ninh Bình', NULL),
(20, 'Phủ Lý', NULL),
(21, 'Thanh Hóa', NULL),
(22, 'Thái Bình', NULL),
(23, 'Thủ đô Hà Nội', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `roleID` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`roleID`, `name`) VALUES
(1, 'Admin'),
(2, 'Customer'),
(3, 'User');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role_permission`
--

CREATE TABLE `role_permission` (
  `roleID` int(11) NOT NULL,
  `permissionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shippers`
--

CREATE TABLE `shippers` (
  `shipperID` int(11) NOT NULL,
  `shipperName` varchar(50) NOT NULL,
  `DOB` date DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `creator` int(11) NOT NULL,
  `createOn` date DEFAULT NULL,
  `updateOn` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `shippers`
--

INSERT INTO `shippers` (`shipperID`, `shipperName`, `DOB`, `gender`, `creator`, `createOn`, `updateOn`) VALUES
(1, 'Nguyen Van An', NULL, 0, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipper_address`
--

CREATE TABLE `shipper_address` (
  `shipperID` int(11) NOT NULL,
  `countryID` int(11) NOT NULL,
  `provinceID` int(11) NOT NULL,
  `districtID` int(11) NOT NULL,
  `subdistrictID` int(11) NOT NULL,
  `eaID` int(11) NOT NULL,
  `addressDetail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slides`
--

CREATE TABLE `slides` (
  `slide_id` int(11) NOT NULL,
  `img` varchar(255) NOT NULL,
  `heading` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name_button` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `productID` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `slides`
--

INSERT INTO `slides` (`slide_id`, `img`, `heading`, `description`, `name_button`, `url`, `productID`, `status`) VALUES
(1, 'https://cdn.dribbble.com/users/2317528/screenshots/5332010/nike-adidas_shoe_slider.png', '3 Mẫu giày hot nhất', '<i>Đây là những mẫu bán chạy của shop,</br>\r\n Chiều chuộng những khách hàng khó tính nhất</i>\r\n', 'Click me!', 'ProductController', 1, 1),
(2, 'https://3.bp.blogspot.com/-6NzsUIoOjaQ/Xgivt1hEluI/AAAAAAAAAMg/9wF7Hsm_mUc4NSOFax3vAN4lVKtQ8ka0gCLcBGAsYHQ/s1600/giay.png', 'HunterX', '<i>Tiếp bước hành trình Việt đi khắp 5 châu</i>', 'GO GO', 'ProductController', 1, 1),
(3, 'https://theme.hstatic.net/200000238513/1000665981/14/slider_1.jpg?v=23', 'Cải thiện tốc độ', '<i>Cải thiện tốc độ vượt mọi rào cản</i>', 'Go to shop', 'ProductController', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `statuses`
--

CREATE TABLE `statuses` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `statuses`
--

INSERT INTO `statuses` (`id`, `name`) VALUES
(1, 'Active'),
(2, 'Waiting'),
(3, 'Ban');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sub_district`
--

CREATE TABLE `sub_district` (
  `subdistrictID` int(11) NOT NULL,
  `subdistrictName` varchar(50) NOT NULL,
  `districtID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `suppliers`
--

CREATE TABLE `suppliers` (
  `supplierID` int(11) NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `contactName` varchar(50) NOT NULL,
  `contactTitle` varchar(50) NOT NULL,
  `DOB` date DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `creator` int(11) NOT NULL,
  `createOn` date DEFAULT NULL,
  `updateOn` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `suppliers`
--

INSERT INTO `suppliers` (`supplierID`, `companyName`, `contactName`, `contactTitle`, `DOB`, `gender`, `creator`, `createOn`, `updateOn`) VALUES
(1, 'Nike', 'John Donahoe', 'CEO', NULL, 0, 1, NULL, NULL),
(16, 'Adidas AG', 'Kasper Rorsted', 'CEO', NULL, 0, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier_address`
--

CREATE TABLE `supplier_address` (
  `supplierID` int(11) NOT NULL,
  `countryID` int(11) NOT NULL,
  `provinceID` int(11) NOT NULL,
  `districtID` int(11) NOT NULL,
  `subdistrictID` int(11) NOT NULL,
  `eaID` int(11) NOT NULL,
  `addressDetail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_accounts`
--

CREATE TABLE `user_accounts` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(60) NOT NULL,
  `password` varchar(32) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `middle_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `createdDate` date NOT NULL,
  `lastLogin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user_accounts`
--

INSERT INTO `user_accounts` (`user_id`, `user_name`, `password`, `first_name`, `middle_name`, `last_name`, `gender`, `DOB`, `status_id`, `createdDate`, `lastLogin`) VALUES
(1, 'namnp', '123456', 'Nguyen', 'Phuong', 'Nam ', 0, NULL, 1, '2011-11-11', '0000-00-00'),
(2, 'datvt', '123456', 'Vu', 'Tien', 'Dat', 1, NULL, 1, '2011-11-11', '0000-00-00'),
(3, 'longlb', '123456', 'Le', 'Bao', 'Long', 1, NULL, 1, '2011-11-11', '0000-00-00'),
(4, 'hainx', '123456', 'Nguyen', 'Xuan', 'Hai', 1, NULL, 1, '2011-11-11', '0000-00-00'),
(5, 'vutiendatfa', '123456', 'Vu', 'Tien', 'Dat', 0, NULL, 1, '2011-11-11', '0000-00-00'),
(13, 'vutiendatfb', '123456', 'Vu', 'Tien', 'Dat1', 0, NULL, 1, '2011-11-11', '0000-00-00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_address`
--

CREATE TABLE `user_address` (
  `userID` int(11) NOT NULL,
  `countryID` int(11) NOT NULL,
  `provinceID` int(11) NOT NULL,
  `districtID` int(11) NOT NULL,
  `subdistrictID` int(11) NOT NULL,
  `eaID` int(11) NOT NULL,
  `addressDetail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_role`
--

CREATE TABLE `user_role` (
  `roleID` int(11) NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`blog_id`),
  ADD KEY `category_blog_id` (`blogCategoryID`),
  ADD KEY `fk_Blog_User_Account1` (`userID`);

--
-- Chỉ mục cho bảng `blog_categories`
--
ALTER TABLE `blog_categories`
  ADD PRIMARY KEY (`blogCategoryID`);

--
-- Chỉ mục cho bảng `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`cartID`),
  ADD KEY `fk_Cart_User_Account_idx` (`userID`);

--
-- Chỉ mục cho bảng `cart_items`
--
ALTER TABLE `cart_items`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `fk_Category_Item_Cart1_idx` (`cartID`),
  ADD KEY `fk_Category_Item_Products1_idx` (`productID`);

--
-- Chỉ mục cho bảng `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`countryID`);

--
-- Chỉ mục cho bảng `districts`
--
ALTER TABLE `districts`
  ADD PRIMARY KEY (`districtID`),
  ADD KEY `fk_dis_province` (`provinceID`);

--
-- Chỉ mục cho bảng `electronicaddress`
--
ALTER TABLE `electronicaddress`
  ADD PRIMARY KEY (`eaID`);

--
-- Chỉ mục cho bảng `favorite_products`
--
ALTER TABLE `favorite_products`
  ADD PRIMARY KEY (`userID`,`productID`),
  ADD KEY `fk_fp_product` (`productID`);

--
-- Chỉ mục cho bảng `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `fk_FeedBack_User_Account1_idx` (`userID`),
  ADD KEY `fk_feedback_products1_idx` (`productID`);

--
-- Chỉ mục cho bảng `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`img_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `messengers`
--
ALTER TABLE `messengers`
  ADD PRIMARY KEY (`messengerID`),
  ADD KEY `fk_messengers_User1` (`fromID`),
  ADD KEY `fk_messengers_User2` (`toID`);

--
-- Chỉ mục cho bảng `oder_details`
--
ALTER TABLE `oder_details`
  ADD PRIMARY KEY (`order_detailID`),
  ADD KEY `fk_Oder_details_Order1_idx` (`orderID`),
  ADD KEY `fk_Oder_details_Products1_idx` (`productID`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `fk_Order_User_Account1_idx` (`customerID`),
  ADD KEY `fk_Order_shipper` (`shipperID`);

--
-- Chỉ mục cho bảng `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`permissionID`);

--
-- Chỉ mục cho bảng `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `fk_Post_User_Account1_idx` (`userID`),
  ADD KEY `fk_post_postCate` (`postCategoryID`);

--
-- Chỉ mục cho bảng `post_categories`
--
ALTER TABLE `post_categories`
  ADD PRIMARY KEY (`postCategoryID`),
  ADD UNIQUE KEY `post_id` (`postCategoryID`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `fk_Product_Supplier` (`supplierID`),
  ADD KEY `fk_product_category` (`category_id`),
  ADD KEY `fk_product_color` (`colorID`);

--
-- Chỉ mục cho bảng `product_categories`
--
ALTER TABLE `product_categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `product_color`
--
ALTER TABLE `product_color`
  ADD PRIMARY KEY (`colorID`);

--
-- Chỉ mục cho bảng `provinces`
--
ALTER TABLE `provinces`
  ADD PRIMARY KEY (`provinceID`),
  ADD KEY `fk_province_country` (`countryID`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`roleID`);

--
-- Chỉ mục cho bảng `role_permission`
--
ALTER TABLE `role_permission`
  ADD PRIMARY KEY (`roleID`,`permissionID`),
  ADD KEY `fk_RP_R` (`roleID`),
  ADD KEY `fkRP_P` (`permissionID`);

--
-- Chỉ mục cho bảng `shippers`
--
ALTER TABLE `shippers`
  ADD PRIMARY KEY (`shipperID`),
  ADD KEY `fk_shipper_account` (`creator`);

--
-- Chỉ mục cho bảng `shipper_address`
--
ALTER TABLE `shipper_address`
  ADD PRIMARY KEY (`shipperID`,`countryID`,`provinceID`,`districtID`,`subdistrictID`,`eaID`),
  ADD KEY `countryID` (`countryID`),
  ADD KEY `districtID` (`districtID`),
  ADD KEY `subdistrictID` (`subdistrictID`),
  ADD KEY `eaID` (`eaID`);

--
-- Chỉ mục cho bảng `slides`
--
ALTER TABLE `slides`
  ADD PRIMARY KEY (`slide_id`),
  ADD KEY `fk_slide_product` (`productID`);

--
-- Chỉ mục cho bảng `statuses`
--
ALTER TABLE `statuses`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sub_district`
--
ALTER TABLE `sub_district`
  ADD PRIMARY KEY (`subdistrictID`),
  ADD KEY `fk_subdis_district` (`districtID`);

--
-- Chỉ mục cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplierID`),
  ADD KEY `fk_supplier_account` (`creator`);

--
-- Chỉ mục cho bảng `supplier_address`
--
ALTER TABLE `supplier_address`
  ADD PRIMARY KEY (`supplierID`,`countryID`,`provinceID`,`districtID`,`subdistrictID`,`eaID`),
  ADD KEY `countryID` (`countryID`),
  ADD KEY `districtID` (`districtID`),
  ADD KEY `subdistrictID` (`subdistrictID`),
  ADD KEY `eaID` (`eaID`);

--
-- Chỉ mục cho bảng `user_accounts`
--
ALTER TABLE `user_accounts`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `fk_User_Account_Authority1_idx` (`status_id`);

--
-- Chỉ mục cho bảng `user_address`
--
ALTER TABLE `user_address`
  ADD PRIMARY KEY (`userID`,`countryID`,`provinceID`,`districtID`,`subdistrictID`,`eaID`),
  ADD KEY `countryID` (`countryID`),
  ADD KEY `districtID` (`districtID`),
  ADD KEY `subdistrictID` (`subdistrictID`),
  ADD KEY `eaID` (`eaID`);

--
-- Chỉ mục cho bảng `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`roleID`,`userID`),
  ADD KEY `fk_UR_user` (`userID`),
  ADD KEY `roleID` (`roleID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blogs`
--
ALTER TABLE `blogs`
  MODIFY `blog_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `blog_categories`
--
ALTER TABLE `blog_categories`
  MODIFY `blogCategoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `carts`
--
ALTER TABLE `carts`
  MODIFY `cartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `cart_items`
--
ALTER TABLE `cart_items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `countries`
--
ALTER TABLE `countries`
  MODIFY `countryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `districts`
--
ALTER TABLE `districts`
  MODIFY `districtID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `electronicaddress`
--
ALTER TABLE `electronicaddress`
  MODIFY `eaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `images`
--
ALTER TABLE `images`
  MODIFY `img_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `messengers`
--
ALTER TABLE `messengers`
  MODIFY `messengerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `oder_details`
--
ALTER TABLE `oder_details`
  MODIFY `order_detailID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `permissions`
--
ALTER TABLE `permissions`
  MODIFY `permissionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `posts`
--
ALTER TABLE `posts`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `post_categories`
--
ALTER TABLE `post_categories`
  MODIFY `postCategoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `product_categories`
--
ALTER TABLE `product_categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `product_color`
--
ALTER TABLE `product_color`
  MODIFY `colorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `provinces`
--
ALTER TABLE `provinces`
  MODIFY `provinceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `roleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `shippers`
--
ALTER TABLE `shippers`
  MODIFY `shipperID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `slides`
--
ALTER TABLE `slides`
  MODIFY `slide_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `statuses`
--
ALTER TABLE `statuses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `sub_district`
--
ALTER TABLE `sub_district`
  MODIFY `subdistrictID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `supplierID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `user_accounts`
--
ALTER TABLE `user_accounts`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `fk_blog_Cate` FOREIGN KEY (`blogCategoryID`) REFERENCES `blog_categories` (`blogCategoryID`),
  ADD CONSTRAINT `fk_blog_User` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`);

--
-- Các ràng buộc cho bảng `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `fk_Cart_User_Account` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`);

--
-- Các ràng buộc cho bảng `cart_items`
--
ALTER TABLE `cart_items`
  ADD CONSTRAINT `fk_Category_Item_Cart1` FOREIGN KEY (`cartID`) REFERENCES `carts` (`cartID`),
  ADD CONSTRAINT `fk_Category_Item_Products1` FOREIGN KEY (`productID`) REFERENCES `products` (`product_id`);

--
-- Các ràng buộc cho bảng `districts`
--
ALTER TABLE `districts`
  ADD CONSTRAINT `fk_dis_province` FOREIGN KEY (`provinceID`) REFERENCES `provinces` (`provinceID`);

--
-- Các ràng buộc cho bảng `favorite_products`
--
ALTER TABLE `favorite_products`
  ADD CONSTRAINT `fk_fp_product` FOREIGN KEY (`productID`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `fk_fp_user` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`);

--
-- Các ràng buộc cho bảng `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD CONSTRAINT `fk_FeedBack_User_Account1` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`),
  ADD CONSTRAINT `fk_feedback_products1` FOREIGN KEY (`productID`) REFERENCES `products` (`product_id`);

--
-- Các ràng buộc cho bảng `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Các ràng buộc cho bảng `messengers`
--
ALTER TABLE `messengers`
  ADD CONSTRAINT `fk_messengers_User1` FOREIGN KEY (`fromID`) REFERENCES `user_accounts` (`user_id`),
  ADD CONSTRAINT `fk_messengers_User2` FOREIGN KEY (`toID`) REFERENCES `user_accounts` (`user_id`);

--
-- Các ràng buộc cho bảng `oder_details`
--
ALTER TABLE `oder_details`
  ADD CONSTRAINT `fk_Oder_details_Order1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `fk_Oder_details_Products1` FOREIGN KEY (`productID`) REFERENCES `products` (`product_id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_Order_User_Account1` FOREIGN KEY (`customerID`) REFERENCES `user_accounts` (`user_id`),
  ADD CONSTRAINT `fk_Order_shipper` FOREIGN KEY (`shipperID`) REFERENCES `shippers` (`shipperID`);

--
-- Các ràng buộc cho bảng `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `fk_Post_User_Account1` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`),
  ADD CONSTRAINT `fk_post_postCate` FOREIGN KEY (`postCategoryID`) REFERENCES `post_categories` (`postCategoryID`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `fk_Product_Cate` FOREIGN KEY (`category_id`) REFERENCES `product_categories` (`category_id`),
  ADD CONSTRAINT `fk_Product_Supplier` FOREIGN KEY (`supplierID`) REFERENCES `suppliers` (`supplierID`),
  ADD CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `product_categories` (`category_id`),
  ADD CONSTRAINT `fk_product_color` FOREIGN KEY (`colorID`) REFERENCES `product_color` (`colorID`);

--
-- Các ràng buộc cho bảng `provinces`
--
ALTER TABLE `provinces`
  ADD CONSTRAINT `fk_province_country` FOREIGN KEY (`countryID`) REFERENCES `countries` (`countryID`);

--
-- Các ràng buộc cho bảng `role_permission`
--
ALTER TABLE `role_permission`
  ADD CONSTRAINT `fk_RP_P` FOREIGN KEY (`permissionID`) REFERENCES `permissions` (`permissionID`),
  ADD CONSTRAINT `fk_RP_R` FOREIGN KEY (`roleID`) REFERENCES `roles` (`roleID`);

--
-- Các ràng buộc cho bảng `shippers`
--
ALTER TABLE `shippers`
  ADD CONSTRAINT `fk_shipper_account` FOREIGN KEY (`creator`) REFERENCES `user_accounts` (`user_id`);

--
-- Các ràng buộc cho bảng `shipper_address`
--
ALTER TABLE `shipper_address`
  ADD CONSTRAINT `shipper_address_ibfk_1` FOREIGN KEY (`shipperID`) REFERENCES `shippers` (`shipperID`),
  ADD CONSTRAINT `shipper_address_ibfk_2` FOREIGN KEY (`countryID`) REFERENCES `countries` (`countryID`),
  ADD CONSTRAINT `shipper_address_ibfk_3` FOREIGN KEY (`districtID`) REFERENCES `districts` (`districtID`),
  ADD CONSTRAINT `shipper_address_ibfk_4` FOREIGN KEY (`subdistrictID`) REFERENCES `sub_district` (`subdistrictID`),
  ADD CONSTRAINT `shipper_address_ibfk_5` FOREIGN KEY (`eaID`) REFERENCES `electronicaddress` (`eaID`);

--
-- Các ràng buộc cho bảng `slides`
--
ALTER TABLE `slides`
  ADD CONSTRAINT `fk_slide_product` FOREIGN KEY (`productID`) REFERENCES `products` (`product_id`);

--
-- Các ràng buộc cho bảng `sub_district`
--
ALTER TABLE `sub_district`
  ADD CONSTRAINT `fk_subdis_district` FOREIGN KEY (`districtID`) REFERENCES `districts` (`districtID`);

--
-- Các ràng buộc cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  ADD CONSTRAINT `fk_supplier_account` FOREIGN KEY (`creator`) REFERENCES `user_accounts` (`user_id`);

--
-- Các ràng buộc cho bảng `supplier_address`
--
ALTER TABLE `supplier_address`
  ADD CONSTRAINT `supplier_address_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `suppliers` (`supplierID`),
  ADD CONSTRAINT `supplier_address_ibfk_2` FOREIGN KEY (`countryID`) REFERENCES `countries` (`countryID`),
  ADD CONSTRAINT `supplier_address_ibfk_3` FOREIGN KEY (`districtID`) REFERENCES `districts` (`districtID`),
  ADD CONSTRAINT `supplier_address_ibfk_4` FOREIGN KEY (`subdistrictID`) REFERENCES `sub_district` (`subdistrictID`),
  ADD CONSTRAINT `supplier_address_ibfk_5` FOREIGN KEY (`eaID`) REFERENCES `electronicaddress` (`eaID`);

--
-- Các ràng buộc cho bảng `user_accounts`
--
ALTER TABLE `user_accounts`
  ADD CONSTRAINT `fk_Uer_Status` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`);

--
-- Các ràng buộc cho bảng `user_address`
--
ALTER TABLE `user_address`
  ADD CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`),
  ADD CONSTRAINT `user_address_ibfk_10` FOREIGN KEY (`eaID`) REFERENCES `electronicaddress` (`eaID`),
  ADD CONSTRAINT `user_address_ibfk_2` FOREIGN KEY (`countryID`) REFERENCES `countries` (`countryID`),
  ADD CONSTRAINT `user_address_ibfk_3` FOREIGN KEY (`districtID`) REFERENCES `districts` (`districtID`),
  ADD CONSTRAINT `user_address_ibfk_4` FOREIGN KEY (`subdistrictID`) REFERENCES `sub_district` (`subdistrictID`),
  ADD CONSTRAINT `user_address_ibfk_5` FOREIGN KEY (`eaID`) REFERENCES `electronicaddress` (`eaID`),
  ADD CONSTRAINT `user_address_ibfk_6` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`),
  ADD CONSTRAINT `user_address_ibfk_7` FOREIGN KEY (`countryID`) REFERENCES `countries` (`countryID`),
  ADD CONSTRAINT `user_address_ibfk_8` FOREIGN KEY (`districtID`) REFERENCES `districts` (`districtID`),
  ADD CONSTRAINT `user_address_ibfk_9` FOREIGN KEY (`subdistrictID`) REFERENCES `sub_district` (`subdistrictID`);

--
-- Các ràng buộc cho bảng `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_UR_role` FOREIGN KEY (`roleID`) REFERENCES `roles` (`roleID`),
  ADD CONSTRAINT `fk_UR_user` FOREIGN KEY (`userID`) REFERENCES `user_accounts` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
