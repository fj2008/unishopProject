<%@ include file="../layout/header.jsp"%>

    <!--login-->
    <div class="main">
      <main class="form-signin">
    

        <form >
          
          <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
      
          <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Id</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>
      
          <div class="checkbox mb-3">
            <!-- <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label> -->
            <div class="find">
              <div class="find-id">
                <a href="#" style="color: #868686">Find ID</a>
                <a href="#" style="color: #868686">/ PW</a>
              </div>
              <div>
                <a href="/auth/joinForm" style="color: #868686">Sign Up</a>
              </div>
            </div>
          </div>
          
          <button class="w-100 btn btn-lg btn-primary" type="submit" style="background-color: #f5f5f5; border:  #f8f9fa; color: #383838;" >Sign in</button>
          <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
        </form>
      
        
      </main>
    </div>

<%@ include file="../layout/footer.jsp"%>