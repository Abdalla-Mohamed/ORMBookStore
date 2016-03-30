<%-- 
    Document   : categorymanage
    Created on : Mar 8, 2016, 7:15:20 AM
    Author     : Abdalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <script type="text/javascript">
        function validateBookTitle() {
            if (document.myForm.title.value === "")
            {
                var msg1 = "Please enter book title...!";
                document.getElementById("titleError").innerHTML = msg1;
                document.myForm.title.focus();
                return false;
            }
            else {
                document.getElementById("titleError").innerHTML = "";
                return true;
            }
        }
        function validateBookCount() {

            if (document.myForm.count.value === "") {
                var msg2 = "Please enter book count...!";
                document.getElementById("countError").innerHTML = msg2;
                document.myForm.count.focus();
                return false;
            }
            else {
                document.getElementById("countError").innerHTML = "";
                return true;
            }
        }
        function validateBookPrice() {

            if (document.myForm.price.value === "")
            {
                var msg1 = "Please enter book price...!";
                document.getElementById("priceError").innerHTML = msg1;
                document.myForm.price.focus();
                return false;
            }
            else {
                document.getElementById("priceError").innerHTML = "";
                return true;
            }
        }
        function validateBookDesc() {
            if (document.myForm.description.value === "")
            {
                var msg1 = "Please enter book description...!";
                document.getElementById("descError").innerHTML = msg1;
                document.myForm.description.focus();
                return false;
            }
            else {
                document.getElementById("descError").innerHTML = "";
                return true;
            }
        }
        function validateBookQuote() {
            if (document.myForm.quote.value === "")
            {
                var msg1 = "Please enter book quote...!";
                document.getElementById("quoteError").innerHTML = msg1;
                document.myForm.quote.focus();
                return false;
            }
            else {
                document.getElementById("quoteError").innerHTML = "";
                return true;
            }
        }
        function validateBookRate() {

            if (document.myForm.rate.value === "")
            {
                var msg1 = "Please enter book rate...!";
                document.getElementById("rateError").innerHTML = msg1;
                document.myForm.rate.focus();
                return false;
            }
            else {
                document.getElementById("rateError").innerHTML = "";
                return true;
            }
        }
        function validateImgFrnt() {
            $("#exampleInputFileFrnt").change(function () {
                var val = $(this).val();
                switch (val.substring(val.lastIndexOf('.') + 1).toLowerCase()) {
                    case 'gif':
                    case 'jpg':
                    case 'png':
                        document.getElementById("imgError01").innerHTML = "";
                        break;
                    default:
                        $(this).val('');
                        // error message here
                        document.getElementById("imgError01").innerHTML = "Please choose a valid image...!";
                        break;
                }
            });
        }
        function validateImgBack() {

            $("#exampleInputFileBack").change(function () {
                var val = $(this).val();
                switch (val.substring(val.lastIndexOf('.') + 1).toLowerCase()) {
                    case 'gif':
                    case 'jpg':
                    case 'png':
                        document.getElementById("imgError02").innerHTML = "";
                        break;
                    default:
                        $(this).val('');
                        // error message here
                        document.getElementById("imgError02").innerHTML = "Please choose a valid image...!";
                        break;
                }
            });
        }
           function validateImgFHdr() {

            $("#exampleInputFileFHdr").change(function () {
                var val = $(this).val();
                switch (val.substring(val.lastIndexOf('.') + 1).toLowerCase()) {
                    case 'gif':
                    case 'jpg':
                    case 'png':
                        document.getElementById("imgError03").innerHTML = "";
                        break;
                    default:
                        $(this).val('');
                        // error message here
                        document.getElementById("imgError03").innerHTML = "Please choose a valid image...!";
                        break;
                }
            });
        }
           function validateImgSHdr() {

            $("#exampleInputFileSHdr").change(function () {
                var val = $(this).val();
                switch (val.substring(val.lastIndexOf('.') + 1).toLowerCase()) {
                    case 'gif':
                    case 'jpg':
                    case 'png':
                        document.getElementById("imgError04").innerHTML = "";
                        break;
                    default:
                        $(this).val('');
                        // error message here
                        document.getElementById("imgError04").innerHTML = "Please choose a valid image...!";
                        break;
                }
            });
        }
    </script>
    <%@include file='head.jsp'%>


    <body class="sign-in-up">
        <section>
            <div id="page-wrapper" class="sign-in-wrapper">
                <div class="graphs">
                    <div class="sign-up">
                        <form action="/OnlineBookShop/BookManageSrvlt" method="post" name="myForm" enctype="multipart/form-data"  >
                            <h3>New book form</h3>
                            <p class="creating">Having hands on experience in creating innovative designs,I do offer design 
                                solutions which harness.</p>
                            <h5>Personal Information</h5>
                            <div class="sign-u">
                                <div class="sign-up1">
                                    <h4>Book Title* :</h4>
                                </div>
                                <div class="sign-up2">
                                    <input name="title" type="text" placeholder=" " required=" " onblur="validateBookTitle()"/>
                                    <span style="color:red;" id="titleError" > </span>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="sign-u">
                                <div class="sign-up1">
                                    <h4>count* :</h4>
                                </div>
                                <div class="sign-up2">
                                    <input name="count" type="number" placeholder=" " required=" " onblur="validateBookCount()"/>
                                    <span style="color:red;" id="countError" > </span>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="sign-u">
                                <div class="sign-up1">
                                    <h4>price* :</h4>
                                </div>
                                <div class="sign-up2">
                                    <input name="price" type="number" placeholder=" " required=" " onblur="validateBookPrice()"/>
                                    <span style="color:red;" id="priceError" > </span>

                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <h6>book Information</h6>
                            <div class="sign-u">
                                <div class="sign-up1">
                                    <h4>Description* :</h4>
                                </div>
                                <div class="sign-up2">
                                    <input name="description" type="text" placeholder=" " required=" " onblur="validateBookDesc()"/>
                                    <span style="color:red;" id="descError" > </span>
                                </div>
                                <div class="clearfix"> </div>
                            </div>

                            <div class="sign-u">
                                <div class="sign-up1">
                                    <h4>Quote* :</h4>
                                </div>
                                <div class="sign-up2">
                                    <input name="quote" type="text" placeholder=" " required=" " onblur="validateBookQuote()"/>
                                    <span style="color:red;" id="quoteError" > </span>
                                </div>
                                <div class="clearfix"> </div>
                            </div>



                            <div class="sign-u">
                                <div class="sign-up1">
                                    <h4>rate* :</h4>
                                </div>
                                <div class="sign-up2">
                                    <input name="rate"  type="number" placeholder=" " required=" " onblur="validateBookRate()"/>
                                    <span style="color:red;" id="rateError"> </span>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <br>

                            <div class="form-group col-md-6">

                                <label for="exampleInputFile"><h4>front image* :</h4></label>
                                <input type="file" id="exampleInputFileFrnt" name="imgFront" onblur="validateImgFrnt()">
                                <p class="help-block">Example block-level help text here.</p>
                                <span style="color:red;" id="imgError01"> </span>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="exampleInputFile"><h4>back image* :</h4></label>
                                <input type="file" id="exampleInputFileBack" name="imgBack" onblur="validateImgBack()">
                                <p class="help-block">Example block-level help text here.</p>
                                <span style="color:red;" id="imgError02"> </span>
                            </div>

                            <div class="form-group col-md-6">

                                <label for="exampleInputFile"><h4>1st Header image* :</h4></label>
                                <input type="file" id="exampleInputFileFHdr" name="frstHeader" onblur="validateImgFHdr()">
                                <p class="help-block">Example block-level help text here.</p>
                                <span style="color:red;" id="imgError03"> </span>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="exampleInputFile"><h4>2nd Header image* :</h4></label>
                                <input type="file" id="exampleInputFileSHdr" name="scndHeader" onblur="validateImgSHdr()">
                                <p class="help-block">Example block-level help text here.</p>
                                <span style="color:red;" id="imgError04"> </span>
                            </div>

                            <div class="sub_home">

                                <div class="sub_home_left">
                                    <input type="submit" value="Add to store">
                                </div>
                                <div class="sub_home_right">
                                    <p>Go Back to <a href="index.jsp">Home</a></p>
                                </div>
                                <div class="clearfix"> </div>
                            </div>

                        </form>

                    </div>
                </div>
            </div>
            <!--footer section start-->
            <%@include file='footer.jsp'%>
            <!--footer section end-->
        </section>


    </body>
</html>