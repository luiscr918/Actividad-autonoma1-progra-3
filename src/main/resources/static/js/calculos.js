    document.addEventListener("DOMContentLoaded", () => {
        const cantidadInput = document.getElementById("cantidad");
        const precioInput = document.getElementById("precio");
        const subtotalInput = document.getElementById("subtotal");
        const totalInput = document.getElementById("total");

        const calcularTotales = () => {
            const cantidad = parseInt(cantidadInput.value) || 0;
            const precio = parseFloat(precioInput.value) || 0;
            const subtotal = cantidad * precio;
            const total = subtotal * 1.12;

            subtotalInput.value = subtotal.toFixed(2);
            totalInput.value = total.toFixed(2);
        };

        cantidadInput.addEventListener("input", calcularTotales);
    });