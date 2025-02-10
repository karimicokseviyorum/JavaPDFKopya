async function login() {
    try {
        console.log('Login attempt...');
        const response = await fetch("http://localhost:8080/api/auth/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            credentials: 'include',
            body: JSON.stringify({
                username: document.getElementById('username').value,
                password: document.getElementById('password').value
            })
        });

        console.log('Response status:', response.status);
        const data = await response.json();
        console.log('Response data:', data);

    } catch (error) {
        console.error('Login error:', error);
    }
}

async function uploadPdf() {
    try {
        const fileInput = document.getElementById('pdfFile');
        const file = fileInput.files[0];
        if (!file) {
            alert('Lütfen bir PDF dosyası seçin');
            return;
        }

        const formData = new FormData();
        formData.append('file', file);
        formData.append('username', 'demoUser');  // Login olan kullanıcıdan alınabilir
        formData.append('timestamp', Date.now().toString());

        const response = await fetch("http://localhost:8080/api/pdf/upload", {
            method: 'POST',
            credentials: 'include',
            body: formData
        });

        console.log('Upload response status:', response.status);
        const result = await response.text();
        console.log('Upload result:', result);
        document.getElementById('status').textContent = 'Yükleme başarılı!';

    } catch (error) {
        console.error('Upload error:', error);
        document.getElementById('status').textContent = 'Yükleme başarısız: ' + error.message;
    }
}
