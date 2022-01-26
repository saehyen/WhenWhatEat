<template>
   <v-container style="margin : 5vh auto; max-width: 400px; width:100%;">
    
    <validation-observer
    ref="observer"
    v-slot="{ invalid }"
  >
    <form @submit.prevent="submit" 
          align="center">
      <validation-provider
        v-slot="{ errors }"
        name="ID"
        rules="required|max:10"
      >
        <v-text-field
          v-model="ID"
          :counter="10"
          :error-messages="errors"
          label="ID"
          required
        ></v-text-field>
      </validation-provider>
      <validation-provider
        v-slot="{ errors }"
        name="password"
        rules="required|max:10"
        
      >
        <v-text-field
          v-model="password"
          :counter="11"
          :error-messages="errors"
          label="password"
          required
        ></v-text-field>
      </validation-provider>
      <validation-provider
        v-slot="{ errors }"
        name="name"
        rules="required|max:10"
      >
        <v-text-field
          v-model="names"
          :error-messages="errors"
          label="name"
          required
        ></v-text-field>
      </validation-provider>
      
      <validation-provider
        v-slot="{ errors }"
        rules="required"
        name="checkbox"
      >
        <v-checkbox
          v-model="checkbox"
          :error-messages="errors"
          value="1"
          label="개인정보동의"
          type="checkbox"
          required
        ></v-checkbox>
      </validation-provider>

      <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
      >
        회원가입
      </v-btn>
      <v-btn @click="clear">
        초기화
      </v-btn>
    </form>
  </validation-observer>
  </v-container>
</template>

<script>
import { required, digits, email, max, regex } from 'vee-validate/dist/rules'
  import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'
  setInteractionMode('eager')
  extend('digits', {
    ...digits,
    message: '{_field_} needs to be {length} digits. ({_value_})',
  })
  extend('required', {
    ...required,
    message: '{_field_} can not be empty',
  })
  extend('max', {
    ...max,
    message: '{_field_} may not be greater than {length} characters',
  })
  extend('regex', {
    ...regex,
    message: '{_field_} {_value_} does not match {regex}',
  })
  extend('email', {
    ...email,
    message: 'Email must be valid',
  })
export default {
  name: 'Signup',
 components: {
      ValidationProvider,
      ValidationObserver,
    },
    data: () => ({
      name: '',
      phoneNumber: '',
      email: '',
      select: null,
      checkbox: null,
    }),
    methods: {
      submit () {
        this.$refs.observer.validate()
      },
      clear () {
        this.name = ''
        this.phoneNumber = ''
        this.email = ''
        this.select = null
        this.checkbox = null
        this.$refs.observer.reset()
      },
    },
  }
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>