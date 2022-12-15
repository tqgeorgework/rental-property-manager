<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="full-name" class="sr-only">Full Name</label>
      <input
        type="text"
        id="name"
        class="form-control"
        placeholder="Full Name"
        v-model="user.name"
        required
        autofocus
      />
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
       <fieldset required>
        <legend>Please select one of the following:</legend>
        <input type="radio" name="radioBtn" class="radio" v-model="user.role" id="landlord" value="landlord" /><label for="landlord">Landlord</label><br />
        <input type="radio" name="radioBtn" class="radio" v-model="user.role" id="tenant" value="tenant"  /><label for="tenant">Tenant</label><br />
        <input type="radio" name="radioBtn" class="radio" v-model="user.role" id="maintenance" value="maintenance" /><label for="maintenance">Maintenance Worker</label><br />
  </fieldset>
     
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>

       <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        name: '',
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

form {
  display: flex;
  flex-direction: column;
  gap: 10px;

}

@import url("https://fonts.googleapis.com/css2?family=Orbitron:wght@900&display=swap");
button {
  position: relative;
  padding: 4px 20px;

  font: 18px "Orbitron";
  letter-spacing: 1px;
  text-transform: uppercase;
  margin: 40px;

  color: #fff;
  text-shadow: 0 5px 20px rgba(192, 36, 0, 0.4), 0 2px 2px rgba(192, 36, 0, 0.4);
  background-image: radial-gradient(
    100% 75% at 50% 100%,
    #fed262 0%,
    #c40900 100%
  );
  border: none;
  border-radius: 100px;
  box-shadow: inset 0 3px 15px 0 #ae2000, inset 0 -3px 0 0 #fed262,
    inset 0 40px 0 0 rgba(254, 210, 98, 0.4), inset 0 20px 20px 0 #f8bf45,
    0 0 0 8px #000, 0 9px 0 0 #444, 0 0 20px 0 rgba(254, 210, 98, 0.4),
    0 40px 20px -30px rgba(254, 210, 98, 0.2);
}
button:before {
  content: "";
  position: absolute;
  z-index: -2;
  top: -1rem;
  left: -2rem;
  right: -2rem;
  bottom: -1rem;
  background: linear-gradient(#333, #151515);
  border-radius: 100px;
  box-shadow: 0 2px 10px #000, inset 0 2px 0 #444;
}
button:after {
  content: "";
  position: absolute;
  z-index: -1;
  background: #000;
  box-shadow: 0 1px 0 #444;
  height: 10px;
  left: -2rem;
  right: -2rem;
  top: 50%;
  transform: translateY(-50%);
}
button:hover {
  cursor: pointer;
  background-image: radial-gradient(
    100% 75% at 50% 100%,
    #f7b940 0%,
    #a20700 100%
  );
}
button:focus,
button:active {
  outline: none;
  color: #f9e3bf;
  background-image: radial-gradient(
    100% 75% at 50% 100%,
    #f58725 0%,
    #850600 100%
  );
  box-shadow: inset 0 0 50px rgba(0, 0, 0, 0.4), inset 0 0 10px #850600,
    inset 0 3px 15px 0 #ae2000, inset 0 40px 0 0 rgba(254, 210, 98, 0.3),
    inset 0 20px 20px 0 rgba(248, 191, 69, 0.75), 0 0 0 8px #000, 0 9px 0 0 #444;
}

input[type=radio] {

  accent-color: rgb(112, 21, 21);
}

</style>