-- lua/nvimtree_setup.lua
local api = require("nvim-tree.api")

local function on_attach(bufnr)
  local opts = function(desc)
    return { desc = desc, buffer = bufnr, noremap = true, silent = true, nowait = true }
  end

  -- IDE-style navigation
  vim.keymap.set("n", "<CR>", api.node.open.edit, opts("Open"))
  vim.keymap.set("n", "l", api.node.open.edit, opts("Open"))
  vim.keymap.set("n", "h", api.node.navigate.parent_close, opts("Close"))
  vim.keymap.set("n", "v", api.node.open.vertical, opts("Vertical Split"))
  vim.keymap.set("n", "s", api.node.open.horizontal, opts("Horizontal Split"))
end

require("nvim-tree").setup({
  on_attach = on_attach,
  disable_netrw = true,
  hijack_netrw = true,
  open_on_tab = false,
  hijack_cursor = true,
  update_cwd = true,
  view = {
    width = 30,
    side = "left",
  },
  renderer = {
    icons = {
      show = {
        git = true,
        folder = true,
        file = true,
      },
    },
  },
  filters = {
    dotfiles = false,
  },
  actions = {
    open_file = {
      quit_on_open = false,  -- keep tree open
      resize_window = true,  -- auto resize
    },
  },
})

