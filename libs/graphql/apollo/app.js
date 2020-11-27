const apolloProvider = new VueApollo({
  defaultClient: apolloClient,
})

new Vue({
  el: '#app',
  // inject apolloProvider here like vue-router or vuex
  apolloProvider,
  render: h => h(App),
})

// specific options

new Vue({
  apollo: {
    // Apollo specific options
  },
})

```
<template>
  <div>My component</div>
</template>

<script>
export default {
  apollo: {
    // Vue-Apollo options here
  }
}
</script>
```

// Access the default provider with:
this.$apollo.provider.defaultClient