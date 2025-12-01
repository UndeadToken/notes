vim.api.nvim_create_autocmd("BufWritePre", {
  pattern = "*.go",
  callback = function()
    pcall(vim.lsp.buf.format, { async = false })
  end,
})

