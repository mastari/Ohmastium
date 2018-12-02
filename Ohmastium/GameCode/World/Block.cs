using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace Ohmastium {
    class Block {
        public Vector2 pos;
        public string type;

        public Block(int x, int y, string type) {
            this.pos = new Vector2(x, y);
            this.type = type;
        }

        
    }
}
