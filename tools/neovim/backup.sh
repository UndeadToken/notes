# Create a timestamped backup directory
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
BACKUP_DIR=~/nvim-backups/nvim.$TIMESTAMP
mkdir -p ~/nvim-backups

# Backup configs and plugin data
cp -a ~/.config/nvim "$BACKUP_DIR/config" 2>/dev/null || echo "No config found"
cp -a ~/.local/share/nvim "$BACKUP_DIR/share" 2>/dev/null || true
cp -a ~/.local/state/nvim "$BACKUP_DIR/state" 2>/dev/null || true
cp -a ~/.cache/nvim "$BACKUP_DIR/cache" 2>/dev/null || true

echo "✅ Backup complete. Stored at: $BACKUP_DIR"
