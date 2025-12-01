require("conform").setup({
  formatters_by_ft = {
    go = { "gofumpt", "goimports" },
  },
  format_on_save = true,
})

