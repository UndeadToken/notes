-- lsp_setup.lua (Neovim-native)
local lsp = vim.lsp
local mason_lspconfig = require("mason-lspconfig")

-- Ensure gopls installed via Mason
mason_lspconfig.setup({ ensure_installed = { "gopls" } })

-- Attach keymaps per buffer
local on_attach = function(client, bufnr)
  local map = function(mode, lhs, rhs)
    vim.keymap.set(mode, lhs, rhs, { buffer = bufnr, silent = true })
  end
  map("n", "gd", lsp.buf.definition)
  map("n", "gD", lsp.buf.declaration)
  map("n", "K", lsp.buf.hover)
  map("n", "gi", lsp.buf.implementation)
  map("n", "<leader>rr", lsp.buf.rename)
  map("n", "<leader>ca", lsp.buf.code_action)
end

-- Configure gopls
lsp.start({
  name = "gopls",
  cmd = { "gopls" },
  filetypes = { "go", "gomod" },
  root_dir = vim.fs.dirname(vim.loop.cwd()), -- or use project root logic
  settings = {
    gopls = {
      gofumpt = true,
      staticcheck = true,
      analyses = { unusedparams = true },
    },
  },
  on_attach = on_attach,
})

