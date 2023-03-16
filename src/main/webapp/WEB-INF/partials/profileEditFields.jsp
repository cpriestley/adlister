<fieldset class="width-80">
    <div class="form-group">
        <label for="username" class="form-label">Username</label>
        <input type="text" id="username" name="username" class="form-control">
    </div>
    <div class="form-group">
        <label for="email" class="form-label">Email</label>
        <input type="email" id="email" name="email" class="form-control">
    </div>
    <div class="form-group">
        <label for="password" class="form-label">Password</label>
        <input type="password" id="password" name="password" class="form-control">
    </div>
    <div class="form-group">
        <label for="passwordConfirmation" class="form-label">Password Confirmation</label>
        <input type="password" id="passwordConfirmation" name="passwordConfirmation" class="form-control">
    </div>
    <button class="btn btn-block" type="submit">${requestScope.buttonText}</button>
</fieldset>