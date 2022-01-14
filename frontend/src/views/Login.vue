<template>
   <v-container >
    <v-card-title class="primary--text" 
          align="center">
       <v-form >
    <v-container fluid>
      <v-row >
        <v-col
          cols="12"
        >
          <v-text-field
            :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show2 ? 'text' : 'password'"
            name="input-10-2"
            label="아이디"
            hint="At least 8 characters"
            value="wqfasds"
            class="input-group--focused"
            @click:append="show2 = !show2"
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
        >
          <v-text-field
            v-model="password"
            :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show1 ? 'text' : 'password'"
            name="input-10-1"
            label="비밀번호"
            hint="At least 8 characters"
            counter
            @click:append="show1 = !show1"
          ></v-text-field>
          <v-btn
            color="black"
            text
            to="/"
          >
            로그인
          </v-btn>

          <v-btn
            color="black"
            text
            to="/Signup"
          >
            회원가입
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
       </v-form>
     </v-card-title>
  </v-container>
</template>

<script>
export default {
  name: 'Login',
  data () {
      return {
        show1: false,
        show2: true,
        show3: false,
        show4: false,
        password: 'Password',
        rules: {
          required: value => !!value || 'Required.',
          min: v => v.length >= 8 || 'Min 8 characters',
          emailMatch: () => (`The email and password you entered don't match`),
        },
      }
  }
}
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>