require("nvim-treesitter.configs").setup({
  ensure_installed = { "go", "gomod", "gosum", "lua", "json" },
  highlight = { enable = true },
  indent = { enable = true },
})
