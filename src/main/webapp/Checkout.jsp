<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - TWT-Foods</title>
    <link rel="icon" type="image/png" href="https://user-gen-media-assets.s3.amazonaws.com/gpt4o_images/43548a9a-89bb-492e-add7-0ee0e93722f5.png">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="Checkout.css">
</head>
<body>
    <div class="checkout-container">
        <h2>Checkout</h2>
        <form id="checkoutForm" autocomplete="off" method="post">
            <div class="form-row">
                <div class="form-group">
                    <label for="street">Street</label>
                    <input type="text" id="street" name="street" placeholder="Enter street address" required>
                </div>
                <div class="form-group">
                    <label for="area">Area</label>
                    <input type="text" id="area" name="area" placeholder="Enter area or locality" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="city">City</label>
                    <select id="city" name="city" required>
                        <option value="">Select your city</option>
                        <option value="Hyderabad">Hyderabad</option>
                        <option value="Bangalore">Bangalore</option>
                        <option value="Chennai">Chennai</option>
                        <option value="Mumbai">Mumbai</option>
                        <option value="Delhi">Delhi</option>
                        <option value="Other">Other (Type below)</option>
                    </select>
                    <input type="text" id="customCity" name="customCity" placeholder="Type your city" style="display:none; margin-top:0.5rem;" />
                </div>
                <div class="form-group">
                    <label for="pincode">Pincode</label>
                    <input type="number" id="pincode" name="pincode" placeholder="Enter pincode" required>
                </div>
            </div>
            <div class="form-group">
                <label for="payment">Payment Method</label>
                <select id="payment" name="payment" required>
                    <option value="credit">Credit Card</option>
                    <option value="debit">Debit Card</option>
                    <option value="cod">Cash on Delivery</option>
                </select>
            </div>
            <button type="submit" class="place-order-btn">Place Order</button>
        </form>
    </div>
    <!-- Modal Popup -->
    <div class="modal" id="orderModal">
        <div class="modal-content">
            <div class="checkmark"><i class="fas fa-motorcycle"></i></div>
            <h3>Your order is on the way!</h3>
            <p>Just wait for a few minutes.<br>Thank you for ordering with TWT-Foods!</p>
        </div>
    </div>
    <script>
        // City dropdown logic
        const citySelect = document.getElementById('city');
        const customCityInput = document.getElementById('customCity');
        citySelect.addEventListener('change', function() {
            if (this.value === 'Other') {
                customCityInput.style.display = 'block';
                customCityInput.required = true;
            } else {
                customCityInput.style.display = 'none';
                customCityInput.required = false;
            }
        });
        // Form submit and modal popup
        document.getElementById('checkoutForm').addEventListener('submit', function(e) {
            e.preventDefault();
            document.getElementById('orderModal').classList.add('active');
            setTimeout(() => {
                document.getElementById('orderModal').classList.remove('active');
                window.location.href ='home'; // Redirect to home or order summary
            }, 3500);
        });
    </script>
</body>
</html> 
