<footer class="text-body-secondary  bg-body-tertiary py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Back to top</a>
    </p>
    <p class="mb-1"> &copy; Learnix,a &copy;<strong>Swarnavo</strong> Production.</p>
    <p class="mb-0">This is cool! Isn't it? <a href="/">Check out more on <strong>swarnavo's</strong> Github</a> or read our <a href="/docs/5.3/getting-started/introduction/">getting started guide</a>.</p>
  </div>
</footer>


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