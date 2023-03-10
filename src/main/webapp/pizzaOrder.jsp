<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="resources/font-awesome-4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="resources/css/order-pizza.css">
  <title>Pizza World</title>
</head>
<body>
<!--    Navbar Section-->
<header>
  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <a href="#" class="navbar-brand">Pizza World</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav w-100">
          <li class="nav-item">
            <a href="#" class="nav-link active">Order Online</a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">Menu</a>
          </li>
          <li class="nav-item">
            <form class="d-flex">
              <label for="zip-code-search" class="me-2">
                <input class="form-control" id="zip-code-search" type="search"
                       placeholder="Zip Code">
              </label>
              <button class="btn btn-outline-primary text-nowrap" id="zip-code-btn">
                Search Stores Near You!
              </button>
            </form>
          </li>
          <li class="nav-item ms-lg-auto">
            <a href="#" class="nav-link"><i class="fa fa-user me-2"></i>Sign Up!</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>
<main class="container">
  <!-- Hero Section-->
  <div class="jumbotron d-none d-md-flex">
    <h2 class="bg-light bg-opacity-50 text-center w-100 py-3">Welcome to Pizza World!</h2>
  </div>
  <h2 class="mt-5">Build your own pizza!</h2>
  <!-- Start Tab Section-->
  <ul class="nav nav-tabs" id="tab-names">
    <li class="nav-item">
      <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#size-crust" type="button"><span
              class="badge rounded-pill bg-dark me-2" id="nav-size-crust">1</span>Size and Crust
      </button>
    </li>
    <li class="nav-item">
      <button class="nav-link" data-bs-toggle="tab" data-bs-target="#cheese-sauce" type="button"><span
              class="badge rounded-pill bg-dark me-2" id="nav-cheese-sauce">2</span>Cheese and Sauce
      </button>
    </li>
    <li class="nav-item">
      <button class="nav-link" data-bs-toggle="tab" data-bs-target="#toppings" type="button"><span
              class="badge rounded-pill bg-dark me-2" id="nav-toppings">3</span>Toppings
      </button>
    </li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane fade show active" id="size-crust">
      <div class="card">
        <div class="card-header bg-primary text-white">
          Choose Size and Crust
        </div>
        <div class="card m-3">
          <div class="card-header">
            Hand Tossed
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Garlic seasoned crust with a rich, buttery taste.</li>
            <li class="list-group-item">
              <input class="form-check-input" type="radio" name="sizeAndCrust" id="hand-small" value='Hand Tossed - Small (10")' checked>
              <label class="form-check-label" for="hand-small">
                Small (10")
              </label>
            </li>
            <li class="list-group-item">
              <input class="form-check-input" type="radio" name="sizeAndCrust" id="hand-medium" value='Hand Tossed - Medium (12")'>
              <label class="form-check-label" for="hand-medium">
                Medium (12")
              </label>
            </li>
          </ul>
        </div>
        <div class="card m-3">
          <div class="card-header">
            Crispy Thin
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Garlic seasoned crust with a rich, buttery taste.</li>
            <li class="list-group-item">
              <input class="form-check-input" type="radio" name="sizeAndCrust" id="thin-medium" value='Crispy Thin - Medium (12")'>
              <label class="form-check-label" for="thin-medium">
                Medium (12")
              </label>
            </li>
            <li class="list-group-item">
              <input class="form-check-input" type="radio" name="sizeAndCrust" id="thin-large" value='Crispy Thin - Large (14")'>
              <label class="form-check-label" for="thin-large">
                Large (14")
              </label>
            </li>
          </ul>
        </div>
        <footer class="card-footer d-flex justify-content-end">
          <nav class="nav nav-tab" id="size-crust-footer">
            <button class="btn btn-primary" type="button" id="next-step">
              Next Step <i class="fa fa-arrow-right"></i>
            </button>
          </nav>
        </footer>
      </div>
    </div>
    <div class="tab-pane fade" id="cheese-sauce">
      <div class="card">
        <div class="card-header bg-primary text-white">
          Choose Size and Crust
        </div>
        <div class="card m-3">
          <div class="card-header">
            Cheese
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">How Much?</li>
            <li class="list-group-item">
              <!-- select  -->
              <label for="cheese-amount">
                <select class="form-select" id="cheese-amount">
                  <option value="1">Light</option>
                  <option value="2" selected>Normal</option>
                  <option value="3">Extra</option>
                  <option value="4">Double</option>
                </select>
              </label>
            </li>
          </ul>
        </div>
        <div class="card m-3">
          <div class="card-header">
            Sauce
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">What Type?</li>
            <li class="list-group-item">
              <label for="what-type-topping">
                <select class="form-select" id="what-type-topping">
                  <option value="1" selected>Tomato</option>
                  <option value="2">Marinara</option>
                  <option value="3">BBQ</option>
                  <option value="4">Alfredo</option>
                </select>
              </label>
            </li>
            <li class="list-group-item">How Much?</li>
            <li class="list-group-item">
              <label for="how-much-topping">
                <select class="form-select" id="how-much-topping">
                  <option value="1">Light</option>
                  <option value="2" selected>Normal</option>
                  <option value="3">Extra</option>
                </select>
              </label>
            </li>
          </ul>
        </div>
        <footer class="card-footer d-flex justify-content-end">
          <nav class="nav nav-tab" id="cheese-sauce-footer">
            <button class="btn btn-primary" type="button" onclick="document.getElementById('nav-size-crust').click();">
              <i class="fa fa-arrow-left"></i> Previous
            </button>
            <button class="btn btn-primary" type="button" onclick="document.getElementById('nav-toppings').click();">
              Next <i class="fa fa-arrow-right"></i>
            </button>
          </nav>
        </footer>
      </div>
    </div>
    <div class="tab-pane fade" id="toppings">
      <div class="card">
        <div class="card-header bg-primary text-white">
          Choose Toppings
        </div>
        <div class="card m-3">
          <div class="card-header">
            Choose Meats
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="meat1">
                <label class="form-check-label" for="meat1">
                  Beef
                </label>
              </div>
            </li>
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="meat2">
                <label class="form-check-label" for="meat2">
                  Ham
                </label>
              </div>
            </li>
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="meat3">
                <label class="form-check-label" for="meat3">
                  Philly Steak
                </label>
              </div>
            </li>
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="meat4">
                <label class="form-check-label" for="meat4">
                  Bacon
                </label>
              </div>
            </li>
          </ul>
        </div>
        <div class="card m-3">
          <div class="card-header">
            Choose Non-Meats
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="non-meat1">
                <label class="form-check-label" for="non-meat1">
                  Green Peppers
                </label>
              </div>
            </li>
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="non-meat2">
                <label class="form-check-label" for="non-meat2">
                  Mushrooms
                </label>
              </div>
            </li>
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="non-meat3">
                <label class="form-check-label" for="non-meat3">
                  Onions
                </label>
              </div>
            </li>
            <li class="list-group-item">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="non-meat4">
                <label class="form-check-label" for="non-meat4">
                  Jalapeño Peppers
                </label>
              </div>
            </li>
          </ul>
        </div>
        <footer class="card-footer d-flex justify-content-end">
          <nav class="nav nav-tab" id="toppings-footer">
            <form action="./pizza-order" method="post" id="order-submission">
              <input type="hidden" name="crust" id="crust" value="Crispy Thin">
              <input type="hidden" name="sauce" id="sauce" value="Tomato">
              <input type="hidden" name="size" id="size" value='Medium (12")'>
              <input type="hidden" name="toppings" id="toppings-jsp" value="Bacon">
              <input type="hidden" name="delivery-address" id="delivery-address" value="123 Main St., Anytown, TX 77777">
              <button class="btn btn-primary" type="submit">
                Checkout <i class="fa fa-shopping-cart"></i>
              </button>
            </form>
          </nav>
        </footer>
      </div>
    </div>
  </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="./resources/js/order-pizza.js"></script>
</body>
</html>
