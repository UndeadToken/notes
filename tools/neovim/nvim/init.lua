-- init.lua
local lazypath = vim.fn.stdpath("data") .. "/lazy/lazy.nvim"
if not vim.loop.fs_stat(lazypath) then
  vim.fn.system({
    "git",
    "clone",
    "--filter=blob:none",
    "https://github.com/folke/lazy.nvim.git",
    "--branch=stable",
    lazypath,
  })
end
vim.opt.rtp:prepend(lazypath)

-- Core settings
require("core.options")
require("core.keymaps")
require("core.autocmds")

-- Plugins
require("plugins")

-- Module setups
require("treesitter_setup")
require("cmp_setup")
require("lsp_setup")
require("conform_setup")
require("dap_setup")
require("neotest_setup")
require("ui_setup")

