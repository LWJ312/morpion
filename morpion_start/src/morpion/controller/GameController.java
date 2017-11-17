package morpion.controller;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import morpion.model.Player;
import morpion.view.GameView;

/**
 * 游戏控制器，用于响应玩家的鼠标操作
 *
 */
public class GameController implements MouseListener {
	/** 棋盘视图的引用 */
	private GameView gv;
	
	public GameController(GameView gv){
		this.gv = gv;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 3.1
		// 如果当前游戏仍未结束
		if(!this.gv.getGame().isGameEnded()){
			// 获取光标所在棋盘格
			 int sBlockId=this.gv.getBv().getSelectedBlockId(arg0.getX(), arg0.getY());
			// 如果当前光标所在block没有棋子
			 if(this.gv.getBv().getBoard().getBlock(arg0.getY()/this.gv.getBv().GRID_SIZE,arg0.getX()/this.gv.getBv().GRID_SIZE)==0) {
				// 在棋盘格中填充当前玩家对应的棋子
				 this.gv.getBv().getBoard().setBlock(arg0.getY()/this.gv.getBv().GRID_SIZE,arg0.getX()/this.gv.getBv().GRID_SIZE,this.gv.getGame().getCurrentPlayer().getMark());
			 }
				// 重画棋盘
			 this.gv.getBv().repaint();
		
				// 更新游戏状态，并判断游戏是否结束	
			 if(this.gv.getGame().checkWinner()!=-1) {
				  this.gv.getGame().endGame(this.gv.getGame().checkWinner());
				  this.gv.showEndGameView(this.gv.getGame().checkWinner());
					}
			 else {
				    this.gv.getGame().switchPlayer();
			}
			 //与AI对战
			 if(this.gv.getGame().getGameMode()==1) {
				 this.gv.getGame().getCurrentPlayer().play(this.gv.getBv().getBoard());
				 if(this.gv.getGame().checkWinner()!=-1) {
					  this.gv.getGame().endGame(this.gv.getGame().checkWinner());
					  this.gv.showEndGameView(this.gv.getGame().checkWinner());
						}
				 else {
					    this.gv.getGame().switchPlayer();
				}
			 }
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
