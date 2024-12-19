document.getElementById('new-password').addEventListener('input', function() {
    var password = this.value;
    var status = document.getElementById('password-status');
    var progress = document.getElementById('password-progress');

    if (password.length < 6) {
        status.textContent = 'Demasiado corta';
        progress.value = 20;
        progress.classList.remove('good', 'strong');
    } else if (password.length >= 6 && password.length < 10) {
        status.textContent = 'Usar más caracteres';
        progress.value = 50;
        progress.classList.add('good');
        progress.classList.remove('strong');
    } else {
        status.textContent = 'Contraseña segura';
        progress.value = 100;
        progress.classList.add('strong');
    }
});
