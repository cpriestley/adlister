(function() {
    "use strict";

    document.getElementById("zip-code-btn").addEventListener("click", () => {
        // const zipCode = document.getElementById("zip-code-search").value;
        window.open(`https://www.google.com/maps/search/%22pizza+world%22/`, "_blank");
    });

    document.querySelector("#next-step")
        .addEventListener("click", () => {
            document.getElementById('crust').value = "Foobar";
            document.getElementById('sauce').value = "Foobar";
            document.getElementById("size").value = "Foobar";
            document.getElementById("toppings").value = "Foobar";
            document.getElementById("delivery-address").value = "Foobar";
            document.getElementById('nav-cheese-sauce').click();
        });
})();