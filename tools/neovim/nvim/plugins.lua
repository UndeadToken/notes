-- plugins.lua
local plugins = {
  -- Utilities
  { "nvim-lua/plenary.nvim" },
  { "nvim-tree/nvim-web-devicons" },
  { "nvim-neotest/nvim-nio" }, -- required by dap-ui

  -- Mason & LSP
  { "williamboman/mason.nvim", config = function() require("mason").setup() end },
  { "williamboman/mason-lspconfig.nvim" },
  { "neovim/nvim-lspconfig" },

  -- Completion & Snippets
  { "hrsh7th/nvim-cmp" },
  { "hrsh7th/cmp-nvim-lsp" },
  { "hrsh7th/cmp-buffer" },
  { "hrsh7th/cmp-path" },
  { "L3MON4D3/LuaSnip" },
  { "saadparwaiz1/cmp_luasnip" },

  -- Treesitter
  { "nvim-treesitter/nvim-treesitter", build = ":TSUpdate" },

  -- File explorer
  { "nvim-tree/nvim-tree.lua", dependencies = { "nvim-tree/nvim-web-devicons" } },

  -- Formatter
  { "stevearc/conform.nvim" },

  -- DAP + Go
  { "mfussenegger/nvim-dap" },
  { "leoluz/nvim-dap-go" },
  { "rcarriga/nvim-dap-ui" },

  -- Testing
  { "nvim-neotest/neotest", dependencies = { "nvim-neotest/nvim-nio" } },
  { "nvim-neotest/neotest-go" },

  -- UI
  { "nvim-telescope/telescope.nvim" },
  { "nvim-tree/nvim-tree.lua" },
  { "stevearc/oil.nvim" },
  { "nvim-lualine/lualine.nvim" },
  { "akinsho/bufferline.nvim" },
  { "folke/which-key.nvim" },
  { "rcarriga/nvim-notify" },

  -- Optional Go helper
  { "ray-x/go.nvim" },
}

require("lazy").setup(plugins)

