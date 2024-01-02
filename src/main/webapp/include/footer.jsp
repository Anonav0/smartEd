      <script>
      const darkModeToggle = document.getElementById("darkModeToggle");
      const htmlTag = document.querySelector('html');
      
      htmlTag.setAttribute('data-bs-theme', 'light');
      
      darkModeToggle.addEventListener("click", () => {
    	  console.log('selected')
    	  const active = htmlTag.getAttribute('data-bs-theme');
    	  
    	  htmlTag.setAttribute('data-bs-theme', active === 'light'? 'dark': 'light');
      });

 </script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>